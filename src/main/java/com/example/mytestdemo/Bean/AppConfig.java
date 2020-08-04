package com.example.mytestdemo.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Bean
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/7/15 3:06 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Configuration
public class AppConfig {

    @Bean
    public Hello test(){
       return new Hello();
    }

    public class Hello{
        public Hello(){
            System.out.println("你好你好!");
        }
    }

}

