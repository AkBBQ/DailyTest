package com.example.mytestdemo.controller;

import com.example.mytestdemo.HighJavaDemo.SpringEvent.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事件测试Controller
 */

@RestController
public class EventTestController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/event")
    public void test(){
        eventService.test();
    }
}