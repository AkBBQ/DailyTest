//package com.example.mytestdemo.Config.MyConfig;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
///**
// * 统一的配置中心 用来读取全局唯一配置
// * 这样的好处是 直接可以通过Config.name 读取到对应的配置文件
// * 而不是在多个类里面写上@Value注解的方式去读取
// *
// * 本文中提供了2中初始化方法
// * 1.使用@Value + set方法 给静态变量赋值
// * 2.使用@PostConstruct注解给静态变量赋值
// *
// * @author sunjie
// */
//@Component
//@Slf4j
//public class Config {
//
//    /**
//     * 静态变量1
//     */
//    private static String name;
//
//    /**
//     * 静态变量2
//     */
//    private static String name2;
//
//    /**
//     * 方法一 使用@Value + set方法 给静态变量赋值
//     *
//     * @param n
//     */
//    @Value("${info.name}")
//    public void setName(String n) {
//        log.info("------------初始化姓名---------" + n);
//        name = n;
//        log.info("------------初始化姓名完成---------" + name);
//    }
//
//
//    /**
//     * 方法二 使用@PostConstruct注解
//     *
//     * @PostConstruct注解的方法会将在依赖注入完成之后被自动调用。该注解在整个Bean初始化中执行的顺序：
//     *
//     * @Constructor（构造方法）->@Autowired（依赖注入）->@PostConstruct（注解的方法）
//     */
//    @Value("${info.name}")
//    public String nameNew;
//
//    @PostConstruct
//    public void init() {
//        log.info("------------初始化姓名111---------" + nameNew);
//        name2 = nameNew;
//        log.info("------------初始化姓名完成111---------" + name2);
//    }
//
//}
