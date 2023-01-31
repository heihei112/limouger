package com.run.shopping.service.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.service.entity.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.run.shopping.service.entity.vo.ProductCategoryVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    List<ProductCategoryVo> selectByCategoryOneAndTwo(String parentId);


    List<ProductCategoryVo> selectByPageCateGory(Page<ProductCategoryVo> pageParam, String parentId);

}
