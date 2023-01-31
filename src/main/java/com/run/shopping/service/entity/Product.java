package com.run.shopping.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.run.shopping.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author limou
 * @since 2022-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Product对象", description="")
public class Product extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品名称 ")
    private String name;

    @ApiModelProperty(value = "商品属性列表")
    private String attributeList;

    @ApiModelProperty(value = "商品主图")
    private String mainImg;

    @ApiModelProperty(value = "商品销量")
    private Integer buyCount;

    @ApiModelProperty(value = "商品详情")
    private String details;

    @ApiModelProperty(value = "商品图片列表")
    private String skuImg;

    @ApiModelProperty(value = "商品介绍")
    private String introduce;

    @ApiModelProperty(value = "类别Id")
    private String categoryId;

    @ApiModelProperty(value = "状态 1 正常 2 未发布")
    private Integer status;


}
