package com.example.mytestdemo.form;

import lombok.Data;

/**
 * 登录form
 *
 * @author angtai
 */

@Data
public class UserForm {

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 记住我
     */
    private Boolean rememberMe;
}