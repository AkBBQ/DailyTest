package com.example.mytestdemo.strategy;


import com.example.mytestdemo.strategy.parm.PayCondition;

public interface IPayService extends IBasePayService {

 boolean match(PayCondition payCondition);

}
