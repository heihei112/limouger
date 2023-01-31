package com.run.shopping.service.entity;

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
 * 属性value表
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AttributeValue对象", description="属性value表")
public class AttributeValue extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "属性key外键")
    private String attributeId;

    @ApiModelProperty(value = "属性value值")
    private String attributeValue;


}
