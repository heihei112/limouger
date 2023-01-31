package com.run.shopping.service.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.run.shopping.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车 
 * </p>
 *
 * @author limou
 * @since 2022-08-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ShoppingCart对象", description="购物车 ")
public class ShoppingCart extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品ID")
    private String productId;

    @ApiModelProperty(value = "specsId")
    private String specsId;

    @ApiModelProperty(value = "商品颜色")
    private String productColor;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "购物车商品数量")
    private String cartNum;

    @ApiModelProperty(value = "添加购物车时商品价格")
    private BigDecimal productPrice;


}
