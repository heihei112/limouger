package com.run.shopping.service.service;

import com.run.shopping.service.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.run.shopping.service.entity.vo.LoginVo;
import com.run.shopping.service.entity.vo.RegisterVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
public interface UserService extends IService<User> {

    boolean removeImgById(String id);

    void register(RegisterVo registerVo);

    String login(LoginVo loginVo);
}
