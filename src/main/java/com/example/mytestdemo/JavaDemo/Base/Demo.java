package com.example.mytestdemo.JavaDemo.Base;

public class Demo {

    private String url;

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "url='" + url + '\'' +
                '}';
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setUrl("ahhaha");
        Demo string = demo.getString(demo.getUrl());
        System.out.println(string.toString());
    }

    private Demo getString(String url){
        url = url+"123";
        //return this this代表当前调用这个方法的对象
        return this;
    }
}
