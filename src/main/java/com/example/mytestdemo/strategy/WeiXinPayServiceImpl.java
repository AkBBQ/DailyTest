package com.example.mytestdemo.strategy;

import com.example.mytestdemo.strategy.parm.PayCondition;
import com.example.mytestdemo.strategy.parm.PayRequest;
import com.example.mytestdemo.strategy.parm.QueryRequest;
import org.springframework.stereotype.Service;

@Service
public class WeiXinPayServiceImpl extends BasePayServiceImpl{
    @Override
    public void pay(PayRequest payRequest) {
        System.out.println("微信支付成功");
    }

    @Override
    public void query(QueryRequest queryRequest) {
        System.out.println("微信查询成功");

    }

    @Override
    public boolean match(PayCondition payCondition) {
        return payCondition.getOrderType().equals("2");
    }
}
