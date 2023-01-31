package com.run.shopping.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.run.shopping.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 属性key表
 * </p>
 *
 * @author limou
 * @since 2022-07-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AttributeKey对象", description="属性key表")
public class AttributeKey extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分类外键")
    private String categoryId;

    @ApiModelProperty(value = "属性ke值")
    private String attributeName;



}
