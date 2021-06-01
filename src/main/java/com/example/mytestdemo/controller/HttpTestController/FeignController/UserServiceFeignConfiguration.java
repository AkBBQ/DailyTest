package com.example.mytestdemo.controller.HttpTestController.FeignController;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feigin配置类
 *
 * @author sunjie
 */

@Configuration
public class UserServiceFeignConfiguration {


    /**
     * 日志打印
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 设置超时时间
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }

    /**
     * basic 认证一
     * 通常我们调用的接口都是有权限控制的，很多时候可能认证的值是通过参数去传递的，还有就是通过请求头去传递认证信息，比如 Basic 认证方式。在 Feign 中我们可以直接配置 Basic 认证，代码如下所示。
     */
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "password");
//    }


    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

    /**
     * basic 认证二
     * 或者你可以自定义属于自己的认证方式，其实就是自定义一个请求拦截器。在请求之前做认证操作，然后往请求头中设置认证之后的信息。通过实现 RequestInterceptor 接口来自定义认证方式，代码如下所示。
     * 这样当 Feign 去请求接口的时候，每次请求之前都会进入 FeignBasicAuthRequestInterceptor 的 apply 方法中，在里面就可以做属于你的逻辑了
     */
    public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
        public FeignBasicAuthRequestInterceptor() {
        }

        @Override
        public void apply(RequestTemplate template) {
            // 业务逻辑
            template.header("trace_id", "545748946256");
            template.header("Authorization", "21421124");
        }
    }

    public static void main(String[] args) {
       String ss= "  222333   ";
        System.out.println(StringUtils.trimToEmpty(ss));
    }
}
