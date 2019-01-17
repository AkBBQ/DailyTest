package com.example.mytestdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.controller
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/1/17 1:59 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public List<?> hello(){
       List<String> list=new ArrayList();
       list.add("22");
       list.add("33");
       list.add("王八蛋");
       return list;
    }
}