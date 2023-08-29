package com.example.mytestdemo.strategy.parm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayCondition {

    private  String orderType;


    public static  PayCondition from(PayRequest payRequest){
        return new PayCondition(payRequest.getOrderType());
    }

    public static  PayCondition from(QueryRequest queryRequest){
        return new PayCondition(queryRequest.getOrderType());
    }
}
