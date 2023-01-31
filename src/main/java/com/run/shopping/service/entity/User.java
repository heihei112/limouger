package com.run.shopping.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.run.shopping.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel(value="User对象", description="")
public class User extends BaseEntity {

    private static final long serialVersionUID=1L;


    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "微信授权id")
    private String openid;

    @ApiModelProperty(value = "用户真实姓名")
    private String realname;


    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户头像")
    @TableField("userImg")
    private String userImg;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "用户性别")
    private String sex;

    @ApiModelProperty(value = "用户生日")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date birth;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
