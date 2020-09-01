package com.example.mytestdemo.Command;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Command
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/8/28 5:42 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Data
public class QueryCommand {

    private int id;

    @NotBlank(message = "姓名不能为空!")
    private String name;

    @Email
    @NotBlank(message = "邮箱不能为空!")
    private String email;
}