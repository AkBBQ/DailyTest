package com.example.mytestdemo.Config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis_plus 配置
 */
@Configuration
@MapperScan("com.example.mytestdemo.dao*")
public class MybatisPlusConfig {

}
