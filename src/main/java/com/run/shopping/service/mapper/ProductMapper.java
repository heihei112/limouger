package com.run.shopping.service.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.run.shopping.service.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.run.shopping.service.entity.vo.ProductParamsVo;
import com.run.shopping.service.entity.vo.ProductQueryVo;
import com.run.shopping.service.entity.vo.web.WebProductQueryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author limou
 * @since 2022-08-01
 */
public interface ProductMapper extends BaseMapper<Product> {


    List<ProductParamsVo> selectPageQueryList(Page<ProductParamsVo> paramsVoPage,
                                              @Param(Constants.WRAPPER) QueryWrapper<ProductQueryVo> wrapper);

    List<ProductParamsVo> selectQueryListStor(Page<ProductParamsVo> paramsVoPage,
                                              String productCategoryId,@Param(Constants.WRAPPER) QueryWrapper<WebProductQueryVo> wrapper);

    @Select("select   p.id as productid,p.name as productName,p.attribute_list as attributeList,\n" +
            "\t\tp.main_img as productImg,p.buy_count as buyCount,p.sku_img as productImgList,\n" +
            "\t\tp.introduce as productIntroduce,p.category_id as categoryId,p.status as status,\n" +
            "\t\tpc.title as categoryTitle,ps.id as produc                     tSpecsId,ps.product_specs as productSpecs,\n" +
            "\t\tps.product_stock as productStock,ps.product_price as productPrice from product as p LEFT JOIN\tproduct_specs as ps on p.id = ps.product_id\n" +
            "   left JOIN product_category as pc\n" +
            "   on p.category_id = pc.id WHERE p.id = #{productId}")
    ProductParamsVo selectParmas( String productId);
}
