package com.hjh.exception;

import com.hjh.utils.Resp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Resp ex(Exception e){
        e.printStackTrace();
        return Resp.error(500,"服务器异常！");
    }
}