package com.run.shopping.service.service;

import com.run.shopping.service.entity.ProductSpecs;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 规格表 服务类
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
public interface ProductSpecsService extends IService<ProductSpecs> {

    List<ProductSpecs> selectList(String productId);

}
