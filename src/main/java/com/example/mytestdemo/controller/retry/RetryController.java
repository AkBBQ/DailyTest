package com.example.mytestdemo.controller.retry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RetryController {


    @RequestMapping("/retry")
    public Object hello() throws IOException {
        List<String> list = new ArrayList();
        list.add("22");
        list.add("33");
        list.add("王八蛋");
//        apiServer.add();
        // httpResponse.sendRedirect("https://www.baidu.com");
        return list;
    }

}
