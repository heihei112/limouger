package com.run.shopping.service.entity.vo.web;

import lombok.Data;

/**
 * 		p.name as productName,
 * 		p.main_img as prodcutImg,
 * 		ps.product_stock as productStock,
 * 		sc.product_color as productColor,
 * 		sc.product_price as productPrice,
 * 		sc.cart_num as cartNum
 */
@Data
public class WebShoppingParamVo {
    private String id;
    private String productId;
    private String productSpecs;
    private String productName;
    private String productImg;
    private String productSpecsId;
    private String productStock;
    private String productColor;
    private String productPrice;
    private String cartNum;
}
