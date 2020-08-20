package com.example.mytestdemo.HighJavaDemo.SpringEvent;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package SpringEvent
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/10/30 11:15 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Data
public class Event{
    /**
     * 业务ID
     */
    private Integer id;

    /**
     * 业务消息
     */
    private String message;

    public Event(Integer id, String message) {
        this.id = id;
        this.message = message;
    }
}