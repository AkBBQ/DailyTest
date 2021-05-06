package com.example.mytestdemo.LeeCode.DuoTai;

public class DuoTaiDemo {

    static class Father {
        static {
            System.out.println("Father - static");
        }

        void hello() {
            System.out.println("father");
        }

        public Father() {
            System.out.println("Father - -");
        }
    }

    static class Son1 extends Father {
        @Override
        void hello() {
            System.out.println("Son1");
        }

        static {
            System.out.println("Son1 - static");
        }

        public Son1() {
            System.out.println("Son1 --");
        }
    }

    static class Son2 extends Father {
        @Override
        void hello() {
            System.out.println("Son2");
        }
    }

    public static void main(String[] args) {
        Father father = new Son1();
        father.hello();
    }
}
