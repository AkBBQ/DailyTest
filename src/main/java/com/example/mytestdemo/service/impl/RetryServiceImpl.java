package com.example.mytestdemo.service.impl;

import com.example.mytestdemo.service.RetryService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryServiceImpl implements RetryService {

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 100L, multiplier = 2))
    @Override
    public String hello() {
        System.out.println("执行方法了哈哈哈");
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                throw new RuntimeException("异常了");
            }
        }
        return "成功执行";
    }

    @Recover
    public String recover(RuntimeException e){
        System.out.println("方法重试到了上限"+e.getMessage());
        return "";
    }
}
