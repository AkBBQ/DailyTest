package com.example.mytestdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.mytestdemo.Config.ApiResult;
import com.example.mytestdemo.domain.UserDO;
import com.example.mytestdemo.form.UserForm;
import com.example.mytestdemo.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录
 *
 * @author angtai
 */

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private UserManager userManager;


    @GetMapping(value = "/login.json")
    @ResponseBody
    public ApiResult<?> login(UserForm userForm, HttpServletResponse httpServletResponse) {
        UsernamePasswordToken token = new UsernamePasswordToken(userForm.getName(), userForm.getPassword());
        token.setRememberMe(userForm.getRememberMe());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            if (!currentUser.isAuthenticated()) {
                throw new AuthenticationException();
            }
            UserDO currentUser1 = userManager.getCurrentUser();
            log.info("当前登录的用户为{}", JSON.toJSONString(currentUser1));

            //与shiro无关的实验 登录完成后将用户名字放到cookie中
            //实际上应该放入有有效期限制的sessionId 也叫token
            //后续的所有请求 都要验证token的登录时效性 来判断是否放行或者重新登录
            httpServletResponse.addCookie(new Cookie("userName", currentUser1.getName()));
        } catch (Exception e) {
            return ApiResult.err(null, e.getMessage());
        }
        return ApiResult.ok();
    }


    @GetMapping(value = "/logOut.json")
    @ResponseBody
    public ApiResult<?> logOut() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ApiResult.ok();
    }
}