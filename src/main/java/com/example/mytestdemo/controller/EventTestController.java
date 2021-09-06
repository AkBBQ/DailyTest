package com.example.mytestdemo.controller;

import com.example.mytestdemo.HighJavaDemo.SpringEvent.EventService;
import com.example.mytestdemo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 事件测试Controller
 *
 * @Autowrited 默认 byType 注入 多个实现类配合 @Qualifier 注解使用
 * @Resource byName 注入 根据bean名字注入 也可以指定bean类型
 */

@RestController
public class EventTestController {

    @Autowired
    EventService eventService;

    @Autowired
    @Qualifier("accountDaoImpl2")
    AccountDao accountDao;

    @Resource
    AccountDao sunjie;

    @RequestMapping(value = "/event")
    public void test() {
        eventService.test();
        System.out.println(accountDao.getClass().getName());
        sunjie.hello();
    }
}