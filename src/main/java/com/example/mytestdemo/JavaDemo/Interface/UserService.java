package com.example.mytestdemo.JavaDemo.Interface;

/**
 * 接口中定义的类变量默认都是 public static final 修饰的 且实现类可直接使用
 *
 * @author sunjie
 */
public interface UserService {

    /**
     * 定义的变量类似于静态变量 类似于枚举 实现类可以直接使用
     * 其他类中也可以直接使用接口.变量名 使用
     */

    String SUN_JIE = "HELLO WORLD";

    /**
     * ADD
     *
     * @param name
     */
    void add(String name);

}
