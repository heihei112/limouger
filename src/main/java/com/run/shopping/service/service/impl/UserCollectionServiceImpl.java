package com.run.shopping.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.run.shopping.model.exception.ShoppingException;
import com.run.shopping.service.entity.UserCollection;
import com.run.shopping.service.entity.vo.ProductParamsVo;
import com.run.shopping.service.mapper.UserCollectionMapper;
import com.run.shopping.service.service.UserCollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-09-07
 */
@Service
public class UserCollectionServiceImpl extends ServiceImpl<UserCollectionMapper, UserCollection> implements UserCollectionService {


    @Override
    public IPage<ProductParamsVo> selectList(IPage<ProductParamsVo> pageParam, String userId) {
        LambdaQueryWrapper<UserCollection> qw = new LambdaQueryWrapper<>();
        if (!Objects.isNull(userId)){
            qw.eq(UserCollection::getUserId,userId);
        }
        List<ProductParamsVo> paramsVos =  baseMapper.selectUserList(pageParam,userId);
        pageParam.setRecords(paramsVos);
        return pageParam;
    }

    @Override
    public boolean insertColl(UserCollection userCollection) {
        UserCollection uc = new UserCollection();
        BeanUtils.copyProperties(userCollection,uc);
        LambdaQueryWrapper<UserCollection> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserCollection::getProductId,uc.getProductId());
        UserCollection uss = baseMapper.selectOne(queryWrapper);
        if (!Objects.isNull(uss)){
            baseMapper.deleteById(uss.getId());
            System.out.println(uss);
            return false;
        } else {
            baseMapper.insert(uc);
            return true;
        }

    }
}
