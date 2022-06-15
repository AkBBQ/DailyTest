package com.example.mytestdemo;

import com.example.mytestdemo.service.RetryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RetryTest extends BaseTest{
    @Autowired
    private RetryService retryService;


    @Test
    public void ss(){
        retryService.hello();
    }



}
