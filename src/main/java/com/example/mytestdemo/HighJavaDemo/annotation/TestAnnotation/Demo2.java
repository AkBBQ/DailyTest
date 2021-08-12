//package com.example.mytestdemo.HighJavaDemo.annotation.TestAnnotation;
//
//import com.example.mytestdemo.Config.MyConfig.Config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
///**
// * @PostConstruct注解的方法会将在依赖注入完成之后被自动调用。该注解在整个Bean初始化中执行的顺序：
// *
// * @Constructor（构造方法）->@Autowired（依赖注入）->@PostConstruct（注解的方法）
// *
// * 验证可以在构造方法和init中各自打一个断点 发现在初始化顺序的确为上面所诉
// * @author sunjie
// */
//@Component
//public class Demo2 {
//
//    private String name;
//
//    @Autowired
//    private Config config;
//
//    public Demo2() {
//        System.out.println("构造函数");
//    }
//
//    @PostConstruct
//    public void init() {
//        System.out.println("PostConstruct");
//        name = config.nameNew;
//        System.out.println("PostConstruct:" + name);
//    }
//}
