package com.example.mytestdemo.HighJavaDemo.Aop.DefineAopWithAnnotion;

import com.example.mytestdemo.HighJavaDemo.annotation.DefineDemo.NoLogin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void two() {
        System.out.println("123");
    }
}