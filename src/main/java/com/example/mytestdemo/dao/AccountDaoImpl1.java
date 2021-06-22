package com.example.mytestdemo.dao;

import org.springframework.stereotype.Service;

@Service("sunjie")
public class AccountDaoImpl1 implements AccountDao{
    @Override
    public void hello() {
        System.out.println("AccountDaoImpl1 hello");
    }
}
