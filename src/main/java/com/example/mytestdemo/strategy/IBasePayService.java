package com.example.mytestdemo.strategy;

import com.example.mytestdemo.strategy.parm.PayRequest;
import com.example.mytestdemo.strategy.parm.QueryRequest;

public interface IBasePayService {

 void pay(PayRequest payRequest);

 void query(QueryRequest queryRequest);
}
