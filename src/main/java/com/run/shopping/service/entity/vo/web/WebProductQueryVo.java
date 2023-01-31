package com.run.shopping.service.entity.vo.web;

import lombok.Data;

@Data
public class WebProductQueryVo {

    private String productCategoryId;

    private Integer buyCount;

    private Integer priceType;

    private String search;

}
