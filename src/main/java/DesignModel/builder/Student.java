package DesignModel.builder;

import lombok.Builder;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package DesignModel.builder
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/5/6 10:23 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Builder
public class Student {

    private int id;

    private String name;

    private String age;


    public static void main(String[] args) {
        Student student = Student.builder()
                .age("22")
                .id(1)
                .name("孙杰")
                .build();
    }
}