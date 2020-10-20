package com.example.mytestdemo.HighJavaDemo.DesignModel;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/9/29 9:46 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */


    public class 策略模式 {
        public static void main(String[] args) {
            //关键点 这尼玛不是多态思想吗？
            ICalculator calculator = new Add();


            Context context = new Context(calculator);
            int result = context.calc(1,2);
            System.out.println(result);
        }

        interface ICalculator {
            int calc(int a, int b);
        }

        static class Add implements ICalculator {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        }

        static class Sub implements ICalculator {
            @Override
            public int calc(int a, int b) {
                return a - b;
            }
        }

        static class Multi implements ICalculator {
            @Override
            public int calc(int a, int b) {
                return a * b;
            }
        }

        static class Divide implements ICalculator {
            @Override
            public int calc(int a, int b) {
                return a / b;
            }
        }

        static class Context {
            private ICalculator mCalculator;

            public Context(ICalculator calculator) {
                this.mCalculator = calculator;
            }

            public int calc(int a, int b) {
                return this.mCalculator.calc(a, b);
            }
        }
    }