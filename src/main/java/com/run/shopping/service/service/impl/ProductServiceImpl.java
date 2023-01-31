package com.run.shopping.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.service.entity.Product;
import com.run.shopping.service.entity.ProductSpecs;
import com.run.shopping.service.entity.vo.ProductParamsVo;
import com.run.shopping.service.entity.vo.ProductQueryVo;
import com.run.shopping.service.entity.vo.web.WebProductQueryVo;
import com.run.shopping.service.mapper.ProductMapper;
import com.run.shopping.service.mapper.ProductSpecsMapper;
import com.run.shopping.service.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.shopping.service.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limou
 * @since 2022-08-01
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductSpecsMapper productSpecsMapper;

    @Autowired
    private FileService fileService;

    @Override
    public String insert(Product product) {
        baseMapper.insert(product);
        String productId = product.getId();
        return productId;
    }

    @Override
    public IPage<ProductParamsVo> selectPage(Page<ProductParamsVo> paramsVoPage, ProductQueryVo productQueryVo) {
        QueryWrapper<ProductQueryVo> wrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(productQueryVo.getProductName())) {
            wrapper.like("p.name",productQueryVo.getProductName());
        }
        if (!StringUtils.isEmpty(productQueryVo.getCategoryName())) {
            wrapper.like("pc.title ",productQueryVo.getCategoryName());
        }
        wrapper.groupBy("p.name");

        List<ProductParamsVo> records =  baseMapper.selectPageQueryList(paramsVoPage,wrapper);
        paramsVoPage.setRecords(records);
        return paramsVoPage;
    }

    @Override
    public void deleteIds(String productId) {
        // 删除规格
        productSpecsMapper.delete(new QueryWrapper<ProductSpecs>().eq("product_id",productId));

        // 删除阿里云服务中的主图
        Product product = baseMapper.selectById(productId);
        if (product!=null){
            String url = product.getMainImg();
            if (!StringUtils.isEmpty(url)){
                fileService.removeFile(url);
            }
            // 删除图片列表
            String urls = product.getSkuImg();
            if (!StringUtils.isEmpty(urls)){
                String[] strs = urls.split(",");
                for (String str : strs) {
                    fileService.removeFile(str);
                }
            }
        }
        baseMapper.deleteById(productId);
    }

    @Override
    public IPage<ProductParamsVo> selectPageList(Page<ProductParamsVo> paramsVoPage, WebProductQueryVo productQueryVo) {

        Integer buyCount = productQueryVo.getBuyCount();
        Integer priceType = productQueryVo.getPriceType();
        String productCategoryId = productQueryVo.getProductCategoryId();
        String search = productQueryVo.getSearch();

        QueryWrapper<WebProductQueryVo> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(productCategoryId)) {
            queryWrapper.eq("pc.id",productCategoryId);
        }

        if (!StringUtils.isEmpty(buyCount)){
            if (buyCount == 1){
                queryWrapper.orderByDesc("p.buy_count");
            }
        }
        if (!StringUtils.isEmpty(priceType)) {
            if (priceType == null || priceType == 1) {
                queryWrapper.orderByAsc("productPrice");
            } else {
                queryWrapper.orderByDesc("productPrice");
            }
        }
        if (!StringUtils.isEmpty(search)){
            QueryWrapper<WebProductQueryVo> productName = queryWrapper.like("p.name", search);
            if (productName==null){
                queryWrapper.like("pc.title",search);
            }
        }

        queryWrapper.groupBy("p.name");

        List<ProductParamsVo> paramsVos = baseMapper.selectQueryListStor(paramsVoPage,productCategoryId,queryWrapper );
        paramsVoPage.setRecords(paramsVos);
        return paramsVoPage;
    }

    @Override
    public ProductParamsVo selectById(String productId) {

        return baseMapper.selectParmas(productId);
    }


}
