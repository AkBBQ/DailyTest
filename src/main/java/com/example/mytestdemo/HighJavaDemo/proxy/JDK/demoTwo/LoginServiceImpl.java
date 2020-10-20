package com.example.mytestdemo.HighJavaDemo.proxy.JDK.demoTwo;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.proxy.JDK.demoTwo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/20 11:38 上午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Data
public class LoginServiceImpl implements LoginService {

    private String userName;
    private String password;

    @Override
    public void login(String userName,String password) {
        System.out.println("--------------------被代理类开始-------------------------");
        System.out.println("用户:"+userName+" 登录密码为:"+password);
        System.out.println("--------------------被代理类结束-------------------------");
    }

    public LoginServiceImpl(String userName,String password) {
        this.userName = userName;
        this.password = password;

    }

    public LoginServiceImpl() {
    }

}