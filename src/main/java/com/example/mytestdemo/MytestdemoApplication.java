package com.example.mytestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"SpringEvent","com.example.mytestdemo"})
public class MytestdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytestdemoApplication.class, args);
    }

}

