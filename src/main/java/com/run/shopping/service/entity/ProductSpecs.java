package com.run.shopping.service.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.run.shopping.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 规格表
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ProductSpecs对象", description="规格表")
public class ProductSpecs extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品外键")
    private String productId;

    @ApiModelProperty(value = "商品规格")
    private String productSpecs;

    @ApiModelProperty(value = "商品库存")
    private Integer productStock;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal productPrice;


}
