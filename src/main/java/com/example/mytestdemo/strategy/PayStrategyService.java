package com.example.mytestdemo.strategy;

import com.example.mytestdemo.strategy.parm.PayCondition;
import com.example.mytestdemo.strategy.parm.PayRequest;
import com.example.mytestdemo.strategy.parm.QueryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayStrategyService implements IBasePayService {

    private final List<IPayService> list;

    public PayStrategyService(List<IPayService> list) {
        this.list = list;
    }

    @Override
    public void pay(PayRequest payRequest) {
        getService(PayCondition.from(payRequest)).pay(payRequest);
    }

    @Override
    public void query(QueryRequest queryRequest) {
        getService(PayCondition.from(queryRequest)).query(queryRequest);

    }

    private IPayService getService(PayCondition condition) {
        return list.stream().filter(s -> s.match(condition)).findFirst().orElseThrow(() -> new RuntimeException("未找到实现类"));
    }
}
