package com.example.mytestdemo.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.util.Random;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

/**
 * MD5加解密
 *
 * 正常登录 登录页面明文密码 ->前端加密 ->传到后端 ->后端MD5盐值加密 ->DB
 * 前后端加密 可采用DES加解密算法
 */
@Slf4j
public class Md5Util {

    /**
     * 普通加密 容易被破解
     * @param pwd 加密前的密码
     * @return
     */
    @Deprecated
    public static String encryption(String pwd) {
        return DigestUtils.md5DigestAsHex(pwd.getBytes());
    }

    /**
     * 普通解密 容易被破解
     * @param pwd 加密前的密码
     * @return
     */
    @Deprecated
    public static boolean decrypt(String pwd) {
        //使用md5验证
        return DigestUtils.md5DigestAsHex(pwd.getBytes()).equals(pwd);
    }

    /**
     * 生成含有随机盐的密码
     *
     * @param password 要加密的密码
     *
     * @return String 含有随机盐的密码
     */
    public static String getSaltMD5(String password) {
        // 生成一个16位的随机数
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(16);
        sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
        int len = sBuilder.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sBuilder.append("0");
            }
        }
        // 生成最终的加密盐
        String salt = sBuilder.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }


    /**
     * 验证加盐后是否和原密码一致
     *
     * @param password 原密码
     *
     * @param password 加密之后的密码
     *
     *@return boolean true表示和原密码一致   false表示和原密码不一致
     */
    public static boolean getSaltverifyMD5(String password, String md5str) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5str.charAt(i);
            cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / 3] = md5str.charAt(i + 1);
        }
        String Salt = new String(cs2);
        return md5Hex(password + Salt).equals(String.valueOf(cs1));
    }



    public static void main(String[] args) {
        String pwd = "123456";
        String s = DigestUtils.md5DigestAsHex(pwd.getBytes());
        System.out.println("普通MD5密码:"+s);
        System.out.println("加盐后的密码"+Md5Util.getSaltMD5(pwd));
        System.out.println("验证加盐后是否和原密码一致"+Md5Util.getSaltverifyMD5(pwd,Md5Util.getSaltMD5(pwd)));







    }

}