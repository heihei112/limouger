package com.run.shopping.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.service.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.run.shopping.service.entity.vo.ProductParamsVo;
import com.run.shopping.service.entity.vo.ProductQueryVo;
import com.run.shopping.service.entity.vo.web.WebProductQueryVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author limou
 * @since 2022-08-01
 */
public interface ProductService extends IService<Product> {
    String insert(Product product);

    IPage<ProductParamsVo> selectPage(Page<ProductParamsVo> paramsVoPage, ProductQueryVo productQueryVo);



    void deleteIds(String productId);

    IPage<ProductParamsVo> selectPageList(Page<ProductParamsVo> paramsVoPage, WebProductQueryVo productQueryVo);

    ProductParamsVo selectById(String productId);
}
