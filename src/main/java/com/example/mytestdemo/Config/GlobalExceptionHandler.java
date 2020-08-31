package com.example.mytestdemo.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice(basePackages = "com.example.mytestdemo.controller")
//@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public ApiResult errorMsg(HttpServletRequest request) {
        log.info("接口出现异常:{}", request.getRequestURI());
        return ApiResult.err("系统异常,请联系管理员");
    }
}