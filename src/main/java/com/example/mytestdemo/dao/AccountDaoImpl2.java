package com.example.mytestdemo.dao;

import org.springframework.stereotype.Service;

@Service
public class AccountDaoImpl2 implements AccountDao{
    @Override
    public void hello() {
        System.out.println("AccountDaoImpl2 hello");
    }
}
