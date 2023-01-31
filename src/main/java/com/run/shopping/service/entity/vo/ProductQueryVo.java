package com.run.shopping.service.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productName;

    private String categoryName;
}
