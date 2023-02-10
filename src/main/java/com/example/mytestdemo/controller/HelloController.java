package com.example.mytestdemo.controller;

import com.example.mytestdemo.Command.QueryCommand;
import com.example.mytestdemo.Config.MyException;
import com.example.mytestdemo.HighJavaDemo.annotation.DefineDemo.NoLogin;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
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
@Validated
@RestController
public class HelloController {

    private static Object a = new Object();
    private static  Object b = new Object();

    @RequestMapping("/test/deadLock")
    @NoLogin
    public void deadLock() {
        System.out.println("主线程开始:"+Thread.currentThread().getName());

        new Thread(()->{
            synchronized (a){
                System.out.println("线程1执行");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("线程1执行结束");
                }
            }
        }).start();


        new Thread(()->{
            synchronized (b){
                System.out.println("线程2执行");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("线程2执行结束");
                }
            }
        }).start();

        System.out.println("主线程结束");
    }


    @RequestMapping("/hello")
    public Object hello(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
        List<String> list = new ArrayList();
        list.add("22");
        list.add("33");
        list.add("王八蛋");
       // httpResponse.sendRedirect("https://www.baidu.com");
        return list;
    }

    /**
     * hibernate-validator
     * post请求
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public QueryCommand query1(@RequestBody @Valid QueryCommand query) {
        return query;

    }

    /**
     * hibernate-validator
     * get请求
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "query2", method = RequestMethod.GET)
    public QueryCommand query2(@Valid @RequestBody QueryCommand query) {
        return query;

    }

    /**
     * hibernate-validator
     * get请求
     *
     * @return
     */
    @RequestMapping(value = "query3", method = RequestMethod.GET)
    public String query3(@NotNull(message = "姓名不能为空") String name,
                         @Range(min = 1,max = 3) int age) {
      return name;
    }

    /**
     * 手动抛出异常 让全局异常处理器接异常消息
     *
     * @return
     */
    @RequestMapping(value = "err", method = RequestMethod.GET)
    public void err() {
        throw new RuntimeException("异常");
    }

    /**
     * 手动抛出自定义异常 让全局异常处理器接异常消息
     *
     * @return
     */
    @RequestMapping(value = "myErr", method = RequestMethod.GET)
    public void myErr() throws MyException {
            throw new MyException("自定义异常");
    }
}