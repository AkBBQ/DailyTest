package com.example.mytestdemo.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

/**
 * MD5加解密
 */
@Slf4j
public class Md5Util {

    /**
     * 加密
     * @param pwd 加密前的密码
     * @return
     */
    public static String encryption(String pwd) {
        return DigestUtils.md5DigestAsHex(pwd.getBytes());
    }

    /**
     * 解密
     * @param pwd 加密前的密码
     * @return
     */
    public static boolean decrypt(String pwd) {
        //使用md5验证
        return DigestUtils.md5DigestAsHex(pwd.getBytes()).equals(pwd);
    }


    public static void main(String[] args) {
        String pwd = "123456";
        String s = DigestUtils.md5DigestAsHex(pwd.getBytes());
        System.out.println(s);







    }

}