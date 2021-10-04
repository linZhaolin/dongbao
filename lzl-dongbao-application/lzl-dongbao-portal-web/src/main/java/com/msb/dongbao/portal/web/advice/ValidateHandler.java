package com.msb.dongbao.portal.web.advice;

import com.msb.donbao.common.base.result.ResultWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidateHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request){
        StringBuilder stringBuilder = new StringBuilder();
        for(FieldError fieldError: ex.getBindingResult().getFieldErrors()){
            String defaultMessage=fieldError.getDefaultMessage();
            stringBuilder.append(" "+defaultMessage);
            break;
        }
        return new ResponseEntity(ResultWrapper.builder().code(102).msg(stringBuilder.toString()).build(),HttpStatus.OK);
    }

    public static void main(String[] args) {
        int i=1/0;
    }
}
