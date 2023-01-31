package com.run.shopping.service.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.run.shopping.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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
@ToString
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Order对象", description="")
public class Orders extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "联系人")
    private String linkman;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "邮编")
    private String code;

    @ApiModelProperty(value = "1 微信 2 支付宝")
    private Integer payment;

    @ApiModelProperty(value = "总金额")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "未发货1：已发货2：已收货3：无效订单")
    private Integer status;


}
