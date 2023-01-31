package com.run.shopping.service.mapper;

import com.run.shopping.service.entity.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.run.shopping.service.entity.vo.web.WebShoppingParamVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 购物车  Mapper 接口
 * </p>
 *
 * @author limou
 * @since 2022-08-15
 */
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
    @Select("SELECT sc.id as id, p.id as productId, p.name as productName, p.main_img as productImg, " +
            "ps.id as productSpecsId,ps.product_stock as productStock,ps.product_specs as productSpecs," +
            "sc.product_color as productColor,\n" +
            "sc.product_price as product_price,sc.cart_num as cart_num\n" +
            "FROM \tuser as u LEFT JOIN \tshopping_cart as sc  ON\tu.id = sc.user_id\n" +
            "LEFT JOIN \tproduct  as p  ON\tsc.product_id = p.id \n" +
            "LEFT JOIN \tproduct_specs as ps ON sc.specs_id = ps.id\n" +
            "WHERE\tu.id = #{userId}")
    List<WebShoppingParamVo> selectCartList(String userId);
}
