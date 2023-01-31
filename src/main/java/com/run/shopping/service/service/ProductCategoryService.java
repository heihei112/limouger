package com.run.shopping.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.service.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.run.shopping.service.entity.vo.ProductCategoryVo;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    void batchImport(InputStream inputStream);

    List<ProductCategoryVo> categoryList();

    void removeByOne(String categoryId);

    IPage<ProductCategoryVo> selectPage(Page<ProductCategoryVo> pageParam, String title);
}
