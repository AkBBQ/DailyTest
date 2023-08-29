package com.example.mytestdemo.strategy;

import com.example.mytestdemo.strategy.parm.PayCondition;
import com.example.mytestdemo.strategy.parm.PayRequest;
import com.example.mytestdemo.strategy.parm.QueryRequest;
import org.springframework.stereotype.Service;

@Service
public class AliPayServiceImpl extends BasePayServiceImpl{
    @Override
    public void pay(PayRequest payRequest) {
        System.out.println("支付宝支付成功");

    }

    @Override
    public void query(QueryRequest QueryRequest) {
        System.out.println("支付宝查询成功");
    }

    @Override
    public boolean match(PayCondition payCondition) {
        return payCondition.getOrderType().equals("1");
    }
}
