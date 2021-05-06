package com.example.mytestdemo.LeeCode.NiBoLan;

import java.util.Stack;

public class demo {


    /**
     * 通过逆波兰表达式计算结果
     *
     * @param express
     * @return
     */
    //求逆波兰表达式的值
    public static int calcRevPolishNotation(String express) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < express.length(); i++) {
            // 普通数值的处理
            if ((express.charAt(i) + "").matches("\\d")) {
                stack.push(express.charAt(i) + "");
                // + - * / 运算符的处理
            } else if ((express.charAt(i) + "").matches("[\\+\\-\\*\\/]")) {
                String k1 = stack.pop();
                String k2 = stack.pop();
                // 计算结果
                int res = calcValue(k1, k2, (express.charAt(i) + ""));
                stack.push(res + "");
            }
        }
        return Integer.valueOf(stack.pop());
    }

    //根据运算符计算结果
    private static int calcValue(String k1, String k2, String c) {
        switch (c) {
            case "+":
                return Integer.valueOf(k1) + Integer.valueOf(k2);
            case "-":
                return Integer.valueOf(k2) - Integer.valueOf(k1);
            case "*":
                return Integer.valueOf(k1) * Integer.valueOf(k2);
            case "/":
                return Integer.valueOf(k2) / Integer.valueOf(k1);
            default:
                throw new RuntimeException("没有该类型的运算符！");
        }
    }

}
