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
 * @since 2022-07-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UserAddress对象", description="")
public class UserAddress extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户外键")
    private String uid;

    @ApiModelProperty(value = "收件人姓名")
    private String receiverName;

    @ApiModelProperty(value = "收件人手机号")
    private String receiverMobile;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "县")
    private String county;

    @ApiModelProperty(value = "详细地址")
    private String addr;

    @ApiModelProperty(value = "状态 1正常 0 失效")
    private Integer status;

    @ApiModelProperty(value = "'是否默认地址 1是 1:是  0:否'")
    private Integer commonAddr;

    @ApiModelProperty(value = "是否删除 1删除 0 不删除")
    private Integer isDelete;


}
