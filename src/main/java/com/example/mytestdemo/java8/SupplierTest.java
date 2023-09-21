package com.example.mytestdemo.java8;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            return "123";
        };

        System.out.println(supplier.get());
    }
}
