package com.run.shopping.service.entity.vo;

import com.run.shopping.service.entity.ProductCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductCategoryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String parentId;
    private Integer sort;
    private List<ProductCategory> children = new ArrayList<>();

}
