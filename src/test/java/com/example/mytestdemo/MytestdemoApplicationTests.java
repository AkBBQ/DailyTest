package com.example.mytestdemo;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.mytestdemo.Bean.AppConfig;
import com.example.mytestdemo.Config.Md5Util;
import com.example.mytestdemo.JavaDemo.demo.HeelloRunnable;
import com.example.mytestdemo.JavaDemo.demo.HelloThread;
import com.example.mytestdemo.domain.PeopleDO;
import com.example.mytestdemo.manager.PeopleManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MytestdemoApplicationTests {

    @Resource
    DataSource dataSource;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private PeopleManager peopleManager;

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
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        applicationContext.getBean("test");
        //可以通过注入的方式获取Bean
        appConfig.test();
    }

    @Test
    public void dateSource() throws SQLException {
        System.out.println("数据源" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("链接:" + connection);
        System.out.println("链接地址:" + connection.getMetaData().getURL());

        DruidDataSource druidDataSource = (DruidDataSource)dataSource;
        System.out.println("druid链接最大数:" + druidDataSource.getMaxActive());
        System.out.println("druid初始化连接数:" + druidDataSource.getInitialSize());
        connection.close();
    }

    @Test
    public void addOneUser(){
        PeopleDO peopleDO = new PeopleDO();
        peopleDO.setAge(66);
        peopleDO.setName(Md5Util.getSaltMD5("123456sj"));
        peopleManager.save(peopleDO);
    }
}

