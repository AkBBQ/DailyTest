package com.example.mytestdemo.controller.HttpTestController.FeignController;

import com.example.mytestdemo.controller.HttpTestController.FeignController.domain.CrmMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * query by feign
 *
 * @author sunjie
 */
@FeignClient(name = "myUserService", url = "http://localhost:8080/third/server/")
public interface UserService {

    @GetMapping("query/{name}")
    @ResponseBody
    ResponseEntity<String> query(@PathVariable String name);


    @GetMapping("query2/{name}")
    @ResponseBody
    ResponseEntity<String> query2(@PathVariable String name);

    @PostMapping("add/member")
    @ResponseBody
    ResponseEntity<String> add(@RequestBody CrmMember crmMember);


}
