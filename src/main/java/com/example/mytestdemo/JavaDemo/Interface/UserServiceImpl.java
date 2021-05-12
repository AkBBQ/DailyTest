package com.example.mytestdemo.JavaDemo.Interface;

/**
 * xxx
 *
 * @author sunjie
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add(String name) {
        //直接使用接口中定义的变量
        System.out.println(SUN_JIE);
    }
}
