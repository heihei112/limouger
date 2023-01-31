package com.run.shopping.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.run.shopping.service.entity.UserAddress;
import com.run.shopping.service.mapper.UserAddressMapper;
import com.run.shopping.service.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

    @Override
    public List<UserAddress> selectList(String userId) {

        return baseMapper.selectList(new QueryWrapper<UserAddress>().eq("uid", userId));
    }
}
