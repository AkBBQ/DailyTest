package com.example.mytestdemo.controller.CookieAndSessionController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义添加cookie、session
 */

@Controller
public class CookieAndSessionController {

    @GetMapping("/cookie")
    public void say(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user","15251800012");
        httpServletResponse.addCookie(new Cookie("token","15251800012"));
    }
}