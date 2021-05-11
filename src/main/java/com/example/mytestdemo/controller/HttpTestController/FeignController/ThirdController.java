package com.example.mytestdemo.controller.HttpTestController.FeignController;

import com.alibaba.fastjson.JSONObject;
import com.example.mytestdemo.controller.HttpTestController.FeignController.domain.CrmMember;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟一个使用feign查询
 * <p>
 * A B 通过二种不同的方式将数据塞到 response 的body中
 * A 通过@ResponseBody自动塞
 * B 手动塞
 *
 * @author sunjie
 */

@RestController
@RequestMapping(value = "/third/server")
public class ThirdController {


    /**
     * 第三方的一个接口 A
     * http://localhost:8080/third/server/query/zhangsan
     * 返回一个JSON对象
     */
    @GetMapping("/query/{name}")
    public Map<String, String> hello1(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        Map<String, String> map = new HashMap<>(4);
        map.put("name", name);
        map.put("age", "22");
        map.put("phone", "15251800012");
        map.put("hobby", "games");


        //返回码
        response.setStatus(200);
        //返回头
        response.addHeader("Authorization", "ASDADASD");
        response.addHeader("trace_id", "12312312");
        //返回类型
        response.setContentType("application/json; charset=utf-8");
        return map;
    }


    /**
     * 第三方的一个接口 A
     * http://localhost:8080/third/server/query/zhangsan
     * 返回一个JSON对象
     */
    @GetMapping("/query2/{name}")
    public void hello2(@PathVariable("name") String name, HttpServletResponse response) throws IOException {


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("age", "22");
        jsonObject.put("phone", "15251800012");
        jsonObject.put("hobby", "games");


        //返回码
        response.setStatus(200);
        //返回头
        response.addHeader("Authorization", "ASDADASD");
        response.addHeader("trace_id", "12312312");
        //返回类型
        response.setContentType("application/json; charset=utf-8");

        //返回体
        PrintWriter out = response.getWriter();
        out.write(jsonObject.toString());
        out.flush();
        out.close();
    }

    @PostMapping("/add/member")
    public CrmMember hello3(@RequestBody CrmMember crmMember) {
        System.out.println(JSONObject.toJSONString(crmMember));
        return crmMember;
    }

}