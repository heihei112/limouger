package com.run.shopping.service.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import com.run.shopping.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 广告推荐
 * </p>
 *
 * @author limou
 * @since 2022-07-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Ad对象", description="广告推荐")
public class Ad extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标题")
    private String title;


    @ApiModelProperty(value = "图片地址")
    private String imageUrl;

    @ApiModelProperty(value = "图片状态")
    private Integer status;

    @ApiModelProperty(value = "背景颜色")
    private String color;

    @ApiModelProperty(value = "链接地址")
    private String linkUrl;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("is_delete")
    @TableLogic
    private Boolean deleted;

}
