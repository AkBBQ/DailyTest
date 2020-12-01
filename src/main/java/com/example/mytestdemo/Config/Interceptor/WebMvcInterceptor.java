package com.example.mytestdemo.Config.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置中心
 *
 * @author angtai
 */

@Configuration
public class WebMvcInterceptor extends WebMvcConfigurerAdapter {

    @Autowired
    LoginVerifyInterceptor loginVerifyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginVerifyInterceptor).addPathPatterns("/**/cookie").excludePathPatterns("/**/notLogin.json");
    }
}