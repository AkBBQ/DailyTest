package com.example.mytestdemo.strategy.parm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayRequest {

    private String orderNo;
    private String orderType;
    private String payerName;


}
