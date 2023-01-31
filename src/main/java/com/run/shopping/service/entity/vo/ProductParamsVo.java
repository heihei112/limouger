package com.run.shopping.service.entity.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class ProductParamsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productId;

    private String productName;

    private String attributeList;

    private String productImg;

    private String buyCount;

    private String productImgList;

    private String productIntroduce;

    private String status;

    private String categoryId;

    private String categoryTitle;

    private String productSpecsId;

    private String productSpecs;

    private String productStock;

    private String productPrice;

}
