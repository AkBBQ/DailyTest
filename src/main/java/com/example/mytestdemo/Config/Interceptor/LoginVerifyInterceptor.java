package com.example.mytestdemo.Config.Interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 登录验证拦截器
 * 从cookie中判断当前请求用户是否登录 登录放行 未登录则跳到登录页
 *
 * @author angtai
 */

@Service
public class LoginVerifyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        List<Cookie> cookieList = Arrays.stream(cookies).filter(item -> item.getName().equals("userName")).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(cookieList)) {
            String userName = cookieList.get(0).getValue();
        } else {
            //todo 用户未登录的话 跳转到登录页面
            response.sendRedirect("/notLogin.json");
            return true;
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