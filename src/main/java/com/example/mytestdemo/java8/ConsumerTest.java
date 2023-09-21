package com.example.mytestdemo.java8;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {

        //消费
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("123");
    }


}
