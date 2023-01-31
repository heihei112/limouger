package com.run.shopping.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.service.entity.UserCollection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.run.shopping.service.entity.vo.ProductParamsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author limou
 * @since 2022-09-07
 */
public interface UserCollectionService extends IService<UserCollection> {

    IPage<ProductParamsVo> selectList(IPage<ProductParamsVo> pageParam, String userId);

    boolean insertColl(UserCollection userCollection);

}
