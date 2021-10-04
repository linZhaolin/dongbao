package com.msb.dongbao.portal.web.advice;

import com.msb.donbao.common.base.result.ResultWrapper;
import org.apache.ibatis.executor.resultset.ResultSetWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper curstomException(){

         return ResultWrapper.builder().code(301).msg("统一异常").build();

    }
}
