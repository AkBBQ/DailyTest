package com.example.mytestdemo.Interface;

import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Interface
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/17 1:47 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Service
public class DemoImpl implements Demo {

    @Override
    public String hello(){
        return "123";
    }
}