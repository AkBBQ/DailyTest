package com.example.mytestdemo.java8;

import java.util.Optional;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 5;

        Boolean aBoolean = Optional.of(predicate).map(s -> s.test("123")).orElse(false);
        System.out.println(aBoolean);

//        boolean test = predicate.test("23123123213");
//        System.out.println(test);
    }
}
