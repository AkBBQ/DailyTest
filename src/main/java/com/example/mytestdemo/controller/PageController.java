package com.example.mytestdemo.controller;

import com.example.mytestdemo.Command.User;
import com.example.mytestdemo.Config.ApiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import feign.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 角色为 admin 才能更新
     *
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping(value = "/admin/update.json")
    @ResponseBody
    public ApiResult<?> adminUpdate() {
        return ApiResult.ok("管理员更新");
    }


    @GetMapping("/test/page")
    public List<User> selectAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize) {
        //starePage方法会将分页信息存放到本线程ThreadLocal中，如果像如下这种写法 那么不执行查询情况下 污染了线程 导致下一次查询被玷污

        //解决方案
        //CASE 1 PageHelper对象不共用
        //CASE 2 PageHelper.clearPage();
        //CASE 3 确保 PageHelper.startPage 之后执行查询
        PageHelper.startPage(pageNum, pageSize);
        if (pageNum > 100){
//        List<User> users = userMapper.selectAll();
        }
        List<User> users = new ArrayList<>();
        PageInfo<User> pageInfo = new PageInfo<>(users);

        PageHelper.clearPage();
        return pageInfo.getList();
    }


}