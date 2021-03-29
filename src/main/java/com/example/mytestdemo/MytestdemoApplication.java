package com.example.mytestdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.mytestdemo.*"})
public class MytestdemoApplication {

    public static void main(String[] args) {
        // 启动应用程序，返回应用程序上下文C o
        ConfigurableApplicationContext context = SpringApplication.run(MytestdemoApplication.class, args);
        //通过getEnvironment(),getProperty()方法获取配置属性值
        String port = context.getEnvironment().getProperty("local.server.port");
        log.info("myTestDemo started url: http://localhost:" + port + "/hello");

        log.info("myTestDemo  druid started  url : http://localhost:" + port + "/druid");
    }

}

