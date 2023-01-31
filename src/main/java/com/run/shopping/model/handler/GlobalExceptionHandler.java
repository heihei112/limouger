package com.run.shopping.model.handler;


import com.run.shopping.model.exception.ShoppingException;
import com.run.shopping.model.utils.ExceptionUtils;
import com.run.shopping.model.utils.R;
import com.run.shopping.model.utils.ResultCodeEnum;
import com.run.shopping.service.entity.ShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public R error(Exception e){
        log.error(ExceptionUtils.getMessage(e));
        e.printStackTrace();
        return R.error();
    }

    @ExceptionHandler({BadSqlGrammarException.class})
    @ResponseBody
    public R sqlError(BadSqlGrammarException e){
        log.error(ExceptionUtils.getMessage(e));
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }
    @ExceptionHandler(ShoppingException.class)
    @ResponseBody
    public R error(ShoppingException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
