package com.example.mytestdemo.HighJavaDemo.proxy.JDK.demoTwo;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.proxy.JDK.demoTwo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/20 11:37 上午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */
public interface LoginService {

    void login(String userName, String password);


    /**
     * 匿名内部类
     *
     * @param args
     */
    static void main(String[] args) {
        LoginService loginService = new LoginService() {
            @Override
            public void login(String userName, String password) {
                System.out.println("123");
            }
        };
        loginService.login("s", "2");
    }
}