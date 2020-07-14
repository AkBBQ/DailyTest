package com.example.mytestdemo.Aop.DefineAopWithAnnotion;

import annotation.DefineDemo.NoLogin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 自定义注解 + aop 登录验证
 */


@RestController("/test")
public class DefineAnnotionAndAopController {

    @RequestMapping("/one")
    public String one() {
        return "one";
    }

    @NoLogin
    @RequestMapping("/two")
    public String two() {
        return "two";
    }


    public static void main(String[] args) {


    }

}