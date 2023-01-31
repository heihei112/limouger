package com.run.shopping.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.run.shopping.model.exception.ShoppingException;
import com.run.shopping.model.utils.*;
import com.run.shopping.service.entity.User;
import com.run.shopping.service.entity.vo.LoginVo;
import com.run.shopping.service.entity.vo.RegisterVo;
import com.run.shopping.service.mapper.UserMapper;
import com.run.shopping.service.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.shopping.service.service.file.FileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private FileService fileService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean removeImgById(String id) {
        User user = baseMapper.selectById(id);
        if (user!=null){
            String userImg = user.getUserImg();
            if (!StringUtils.isEmpty(userImg)){
              fileService.removeFile(userImg);
            }
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(RegisterVo registerVo) {
        String nickName = registerVo.getNickName();
        String password = registerVo.getPassword();
        String phone = registerVo.getPhone();
        String code = registerVo.getCode();

        // 校验是否为空
        if (StringUtils.isEmpty(phone) || !FormUtils.isMobile(phone)
        || StringUtils.isEmpty(password) || StringUtils.isEmpty(code)
        || StringUtils.isEmpty(nickName)){
            throw new ShoppingException(ResultCodeEnum.PARAM_ERROR);
        }
        // 校验验证码
        String codeObj = (String)redisTemplate.opsForValue().get(phone);
        if (!code.equals(codeObj)){
            throw new ShoppingException(ResultCodeEnum.CODE_ERROR);
        }

        // 判断是否被注册
        Integer resule = baseMapper.selectCount(new QueryWrapper<User>().eq("phone", phone));
        if (resule > 0) {
            throw new ShoppingException(ResultCodeEnum.REGISTER_MOBLE_ERROR);
        }

        User user =new User()
                .setNickname(nickName)
                .setPassword(MD5.encrypt(password))
                .setPhone(phone)
                .setUserImg("https://guli-file-helen.oss-cn-beijing.aliyuncs.com/avatar/default.jpg");
        baseMapper.insert(user);

    }

    @Override
    public String login(LoginVo loginVo) {

        String phone = loginVo.getPhone();
        String password = loginVo.getPassword();

        //校验参数
        if (StringUtils.isEmpty(phone)
                || !FormUtils.isMobile(phone)
                || StringUtils.isEmpty(password)) {
            throw new ShoppingException(ResultCodeEnum.PARAM_ERROR);
        }

        User user = baseMapper.selectOne(new QueryWrapper<User>().eq("phone", phone));
        if (user == null) {
            throw new ShoppingException((ResultCodeEnum.LOGIN_MOBILE_ERROR));
        }

        // 校验密码
        if(!MD5.encrypt(password).equals(user.getPassword())){
            throw new ShoppingException(ResultCodeEnum.LOGIN_PASSWORD_ERROR);
        }

        JwtInfo jwtInfo = new JwtInfo();
        jwtInfo.setId(user.getId());
        jwtInfo.setAvatar(user.getUserImg());
        jwtInfo.setNickname(user.getNickname());

        String token = JwtUtils.getJwtToken(jwtInfo, 3600);
        return token;
    }
}
