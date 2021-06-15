package com.example.mytestdemo.JavaDemo.Abstract;

/**
 * 接口 抽象类 实现类 三者混合使用
 *
 * 意义 抽象类可以实现接口中的部分方法 那么 在最终实现类继承 抽象类的时候 拥有公共的实现方法
 */
public interface BuySomethingService {

    /**
     * 买东西的人名字
     */
    String getName(String name);

    /**
     * 买东西地址
     * @param place
     * @return
     */
    String getPlace(String place);

    /**
     * 通用的买东西
     */
    String buySomething(String thing);


}
