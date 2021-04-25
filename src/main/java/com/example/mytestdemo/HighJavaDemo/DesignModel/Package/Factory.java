package com.example.mytestdemo.HighJavaDemo.DesignModel.Package;

/**
 * 简单工厂模式
 *
 * @author sunjie
 */
public class Factory {

    public static Product create(String s) {
        switch (s) {
            case "a":
                return new ProductA();
            case "b":
                return new ProductA();
            default:
                return new ProductA();
        }
    }

    public static void main(String[] args) {
        Product product = Factory.create("a");
        Product productb = Factory.create("b");
        product.hello();
        productb.hello();
    }
}
