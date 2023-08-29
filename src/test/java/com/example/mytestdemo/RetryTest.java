package com.example.mytestdemo;

import com.example.mytestdemo.service.RetryService;
import com.example.mytestdemo.strategy.PayStrategyService;
import com.example.mytestdemo.strategy.parm.PayRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RetryTest extends BaseTest{
    @Autowired
    private RetryService retryService;

    @Autowired
    private PayStrategyService payStrategyService;

    @Test
    public void ss(){
        retryService.hello();
    }


    @Test
    public void ts(){
        PayRequest payRequest = new PayRequest();
        payRequest.setOrderNo("21412412412");
        payRequest.setOrderType("2");
        payRequest.setPayerName("张三");


        payStrategyService.pay(payRequest);
    }


}
