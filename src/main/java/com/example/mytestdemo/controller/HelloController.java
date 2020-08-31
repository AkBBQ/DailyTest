package com.example.mytestdemo.controller;

import com.example.mytestdemo.Command.QueryCommand;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.controller
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/1/17 1:59 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public List<?> hello() {
        List<String> list = new ArrayList();
        list.add("22");
        list.add("33");
        list.add("王八蛋");
        return list;
    }

    /**
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public int query(@Validated QueryCommand query) {
        try {
            int id = query.getId();
            return id;
        } catch (Exception e) {
            System.out.println("异常啦!");
        }
        return 123;
    }

    /**
     * 手动抛出异常 让全局异常处理器接异常消息
     *
     * @return
     */
    @RequestMapping(value = "err", method = RequestMethod.GET)
    public void query() {
        throw new RuntimeException("异常");
    }

}