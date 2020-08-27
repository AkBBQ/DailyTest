package com.example.mytestdemo.HighJavaDemo.Aop.DefineAopWithAnnotion;

import com.example.mytestdemo.HighJavaDemo.annotation.DefineDemo.NoLogin;
import com.alibaba.fastjson.JSON;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 登录免登拦截器
 */

@Component
public class LoginInterceptor  implements HandlerInterceptor {

    private final static String CHARSET = "UTF-8";
    private final static String CONTENTTYPE = "application/json;charset=UTF-8";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("小子、被我拦截了吧");

        //如果请求为静态资源请求时，类型转换会报错，类型不对应，所以应再请求时方法请求时再转换类型
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //当请求为方法时，再转换类型
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        //获取方法上免登的注解
        NoLogin annotation = handlerMethod.getMethod().getAnnotation(NoLogin.class);
        if(null == annotation){
            //没有免登注解的话
            System.out.println("滚去登录!");

            response.setStatus(403);
            response.setCharacterEncoding(CHARSET);
            response.setContentType(CONTENTTYPE);
            PrintWriter out = response.getWriter();
            String json = JSON.toJSONString("滚去登录");
            out.write(json);
            out.flush();
            out.close();
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}