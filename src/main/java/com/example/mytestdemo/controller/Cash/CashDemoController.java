package com.example.mytestdemo.controller.Cash;

import com.example.mytestdemo.manager.UserManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * SpringCash demo
 * @author sunjie
 */
@RestController
public class CashDemoController {

@Resource
private UserManager userManager;

    @RequestMapping(value = "/cash")
    public void test() {
        userManager.queryUserByName("张三",1);
        userManager.queryUserByName("张三",1);

        userManager.queryUserByName("李四",2);
        userManager.queryUserByName("李四",2);

        userManager.updateUser("张三",2);
        userManager.queryUserByName("张三",1);

    }
}
