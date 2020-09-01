package com.example.mytestdemo.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice(basePackages = "com.example.mytestdemo.controller")
//@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ApiResult myErr(Exception e, HttpServletRequest request) {
        log.info("接口出现异常:{},错误原因:{}", request.getRequestURI(), e.getMessage());
        //如果是自定义异常
        if (e instanceof MyException) {
            return ApiResult.err("自定义业务异常");
        //参数校验统一异常处理
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            FieldError fieldError = ex.getBindingResult().getFieldError();
            return ApiResult.err(Optional.ofNullable(fieldError).map(DefaultMessageSourceResolvable::getDefaultMessage).orElse("参数校验统一异常处理异常"));
        }
        return ApiResult.err(e.getMessage());
    }
}