package com.example.mytestdemo.HighJavaDemo.Aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.Aop
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/5/19 10:05 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */


@Aspect
@Component
@Slf4j
public class AspectDemo {


    /**
     * 声明一个切点 表示作用域
     */
    @Pointcut("execution(* com.example.mytestdemo.HighJavaDemo.Aop..*.*(..))")
    private void hello(){

    }

    /**
     * 声明一个切点 表示作用域
     */
    @Pointcut("execution(String com.example.mytestdemo.HighJavaDemo.Aop..*.*(..))")
    private void hello2(){

    }

    /**
     * 环绕型通知
     */
    @Around(value = "hello()")
    public Object methodAround(ProceedingJoinPoint point){
        log.info("========================环绕型通知开始======================");
        Object result = null;
        try {
            Object[] objects = point.getArgs();

            //执行Advice方法
            result = point.proceed();

        } catch (Throwable throwable) {
            log.info("环绕型通知捕获了异常");
            return "对不起";

        }
        log.info("========================环绕型通知结束======================");
        return result;
    }
}