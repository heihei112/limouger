package com.run.shopping.service.service;

import com.run.shopping.service.entity.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
public interface UserAddressService extends IService<UserAddress> {

    List<UserAddress> selectList(String userId);

}
