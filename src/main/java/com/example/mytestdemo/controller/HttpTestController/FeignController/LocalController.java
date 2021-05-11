package com.example.mytestdemo.controller.HttpTestController.FeignController;

import com.example.mytestdemo.controller.HttpTestController.FeignController.domain.CrmMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 模拟一个使用feign查询
 *
 * @author sunjie
 */

@RestController
@RequestMapping(value = "/local/server")
public class LocalController {

    @Autowired
    private UserService userService;


    /**
     * 本地接口访问第三方接口A
     * http://localhost:8080/third/server/query/zhangsan
     */
    @GetMapping("/localQuery/{name}")
    public void hello1(@PathVariable("name") String name) throws IOException {
        ResponseEntity<String> responseData = userService.query(name);
        System.out.println("=============================" + responseData);
    }


    /**
     * 本地接口访问第三方接口B
     * http://localhost:8080/third/server/query/zhangsan
     */
    @GetMapping("/localQuery2/{name}")
    public void hello2(@PathVariable("name") String name) throws IOException {
        ResponseEntity<String> responseData = userService.query2(name);
        System.out.println(responseData);

    }

    /**
     * 本地接口访问第三方接口B
     * http://localhost:8080/third/server/add/member
     */
    @PostMapping("/localAdd")
    public CrmMember hello3() {
        CrmMember crmMember = new CrmMember();
        crmMember.setName("Li");
        crmMember.setAge(26);
        ResponseEntity<String> responseData = userService.add(crmMember);
        System.out.println(responseData);
        return crmMember;

    }
}