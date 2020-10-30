package com.example.mytestdemo.controller.RestFulController;

import org.springframework.web.bind.annotation.*;

/**
 * ResetFul 风格 是一种编码规范
 * 对象(使用名词) + 行为(GET、POST、DELETE、PUT) 来定义接口API
 *
 * @author angtai
 */

@RestController
public class DemoController {

    @GetMapping("user")
    public Object findAllUsers() {
        return "";
    }

    @PostMapping("user")
    public Object addUser() {
        return "";
    }


    @DeleteMapping("user")
    public Object deleteOneUser() {
        return "";
    }


    @PutMapping("user")
    public Object updateUser() {
        return "";
    }
}