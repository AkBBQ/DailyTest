package com.example.mytestdemo.LeeCode;

import org.apache.commons.lang3.StringUtils;

public class rule {

    public static void main(String[] args) {
        System.out.println( haha(-1, "123"));

    }

    private static String haha(Integer capacity, String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }

        if (capacity < 0) {
            return null;
        } else if (capacity == 0 || capacity == content.length()) {
            return content;
        }



        if (content.length() > capacity) {
            return  content.substring(content.length() - capacity);
        } else {
            int needZeroSize = capacity - content.length();
            StringBuilder stringBuilder = new StringBuilder();
            while (needZeroSize > 0){
                stringBuilder.append("0");
                needZeroSize --;
            }
            return  stringBuilder.append(content).toString();
        }
    }
}
