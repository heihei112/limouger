package com.run.shopping.service.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.run.shopping.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
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
 * @since 2022-08-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="OrderDateils对象", description="")
public class OrderDateils extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "商品id")
    private String productId;

    @ApiModelProperty(value = "商品图片")
    private String productImg;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "单价")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "购买数量")
    private Integer productNum;

    @ApiModelProperty(value = " 0 '用户收货可评价' 1 已评价 2 未评价")
    private Integer evaluation;


}
