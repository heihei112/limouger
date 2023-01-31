package com.run.shopping.model.exception;

import com.run.shopping.model.utils.ResultCodeEnum;
import lombok.Data;

@Data
public class ShoppingException extends RuntimeException{

    private Integer code;

    public ShoppingException(String message, Integer code) {
        super(message);
        this.code = code;
    }
    public ShoppingException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "ShoppingException{" +
                "code=" + code +
                "message="+getMessage()+
                '}';
    }
}
