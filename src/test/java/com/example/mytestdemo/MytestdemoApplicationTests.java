package com.example.mytestdemo;

import com.example.mytestdemo.Bean.AppConfig;
import com.example.mytestdemo.Config.Interceptor.LoginVerifyInterceptor;
import com.example.mytestdemo.JavaDemo.Abstract.BuySomethingService;
import com.example.mytestdemo.JavaDemo.demo.HeelloRunnable;
import com.example.mytestdemo.JavaDemo.demo.HelloThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MytestdemoApplicationTests extends  BaseTest {

    @Autowired
    Map<String, BuySomethingService> map = new ConcurrentHashMap<>();

    @Resource
    DataSource dataSource;

    @Autowired
    private AppConfig appConfig;

@Test
public void test2(){
    System.out.println(map);
}

    @Test
    public void contextLoads() {
        HelloThread helloThread=new HelloThread();
        //threadClass.run();
        helloThread.start();

    }

    @Test
    public void test(){
        Thread thread=new Thread(new HeelloRunnable());
        thread.start();
    }

    @Test
    public void ss() {
        //可以使用获取bean名称来获取bean
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Object sunjie = applicationContext.getBean("sunjie");
//        可以通过注入的方式获取Bean
//        appConfig.test();
    }

    @Test
    public void dateSource() throws SQLException {
        System.out.println("数据源" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("链接:" + connection);
        System.out.println("链接地址:" + connection.getMetaData().getURL());
//
//        DruidDataSource druidDataSource = (DruidDataSource)dataSource;
//        System.out.println("druid链接最大数:" + druidDataSource.getMaxActive());
//        System.out.println("druid初始化连接数:" + druidDataSource.getInitialSize());
//        connection.close();
    }


}

