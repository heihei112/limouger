package com.run.shopping.model.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author helen
 * @since 2019/12/25
 */
@Data
@ApiModel(value = "全局统一返回结果")
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    public R(){}

    public static com.run.shopping.model.utils.R ok(){
        com.run.shopping.model.utils.R r = new com.run.shopping.model.utils.R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static com.run.shopping.model.utils.R error(){
        com.run.shopping.model.utils.R r = new com.run.shopping.model.utils.R();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return r;
    }

    public static com.run.shopping.model.utils.R setResult(ResultCodeEnum resultCodeEnum){
        com.run.shopping.model.utils.R r = new com.run.shopping.model.utils.R();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }

    public com.run.shopping.model.utils.R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public com.run.shopping.model.utils.R message(String message){
        this.setMessage(message);
        return this;
    }

    public com.run.shopping.model.utils.R code(Integer code){
        this.setCode(code);
        return this;
    }

    public com.run.shopping.model.utils.R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public com.run.shopping.model.utils.R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
