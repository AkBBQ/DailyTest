package com.example.mytestdemo.controller;

import com.example.mytestdemo.HighJavaDemo.SpringEvent.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 事件测试Controller
 */

@Controller
public class EventTestController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/event")
    public void test(){
        eventService.test();
        System.out.println("123");
    }
}