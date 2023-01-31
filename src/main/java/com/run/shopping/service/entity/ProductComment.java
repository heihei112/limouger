package com.run.shopping.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.run.shopping.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-07-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ProductComment对象", description="")
public class ProductComment extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品id")
    private String productId;

    @ApiModelProperty(value = "用户id")
    @TableField("USER_id")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "评论内容")
    private String content;


}
