package com.example.mytestdemo;

import com.example.mytestdemo.Bean.AppConfig;
import com.example.mytestdemo.demo.HeelloRunnable;
import com.example.mytestdemo.demo.HelloThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MytestdemoApplicationTests {

    @Autowired
    private AppConfig appConfig;

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
}

