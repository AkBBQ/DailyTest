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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ApiResult<?> login(UserForm userForm) {
        UsernamePasswordToken token = new UsernamePasswordToken(userForm.getName(), userForm.getPassword());
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
        } catch (Exception e) {
            return ApiResult.err(null, e.getMessage());
        }
        return ApiResult.ok();
    }
}