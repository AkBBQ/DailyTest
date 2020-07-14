package com.example.mytestdemo.Aop;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Aop
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/5/19 10:19 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@RestController
public class IndexController {


    @RequestMapping(value = "sun",method = RequestMethod.POST)
    public String test(@RequestBody People people){

        System.out.println("德玛西亚");
       return "222";
    }
}