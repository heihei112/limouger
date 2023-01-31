package com.run.shopping.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.run.shopping.service.entity.ProductSpecs;
import com.run.shopping.service.mapper.ProductSpecsMapper;
import com.run.shopping.service.service.ProductSpecsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 规格表 服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
@Service
public class ProductSpecsServiceImpl extends ServiceImpl<ProductSpecsMapper, ProductSpecs> implements ProductSpecsService {

    @Override
    public List<ProductSpecs> selectList(String productId) {
        List<ProductSpecs> productSpecs = baseMapper.selectList(new QueryWrapper<ProductSpecs>().eq("product_id", productId));
        return productSpecs;
    }
}
