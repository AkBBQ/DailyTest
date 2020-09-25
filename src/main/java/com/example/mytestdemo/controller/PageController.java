package com.example.mytestdemo.controller;

import com.example.mytestdemo.Config.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录
 *
 * @author angtai
 */

@Controller
public class PageController {

    /**
     * 未登录
     *
     * @return
     */
    @GetMapping(value = "/notLogin.json")
    @ResponseBody
    public ApiResult<?> notLogin() {
        return ApiResult.err("请先登录!");
    }


    /**
     * 无权限
     *
     * @return
     */
    @GetMapping(value = "/notRole.json")
    @ResponseBody
    public ApiResult<?> notRole() {
        return ApiResult.err("对不起,您无权限!");
    }


    @GetMapping(value = "/admin/query.json")
    @ResponseBody
    public ApiResult<?> adminQuery() {
        return ApiResult.err("管理员查询");
    }


}