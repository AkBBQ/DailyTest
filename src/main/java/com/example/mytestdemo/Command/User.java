package com.example.mytestdemo.Command;

import lombok.Builder;
import lombok.Data;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.Command
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/3/22 10:21 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */
@Builder
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Boolean dead;
}