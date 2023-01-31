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
 * 
 * </p>
 *
 * @author limou
 * @since 2022-09-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UserCollection对象", description="")
public class UserCollection extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "商品id")
    private String productId;

    @ApiModelProperty(value = "收藏状态")
    private String collectionStatus;


}
