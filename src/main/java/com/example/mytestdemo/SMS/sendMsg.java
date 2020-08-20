package com.example.mytestdemo.SMS;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 云信使短信服务
 * @author 昂太
 * @date 2019/8/14
 *
 */

public class sendMsg {


    private static final String addr = "http://api.sms.cn/sms/";
    private static final String userId = "sunjie970306";
    private static final String pwd = "b757568f9e1f7be76a301900fe9e9ae8";
    private static final String template = "472402";

    private static final String encode = "utf8";



    public static void send(JSONObject msgContent, String mobile) throws Exception {

//组建请求
        String straddr = addr +
                "?ac=send&uid="+userId+
                "&pwd="+pwd+
                "&template="+template+
                "&mobile="+mobile+
                "&encode="+encode+
                "&content=" + msgContent;

        StringBuffer sb = new StringBuffer(straddr);
        System.out.println("URL:"+sb);

//发送请求
        URL url = new URL(sb.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                url.openStream()));

//返回结果
        String inputline = in.readLine();
        System.out.println("Response:"+inputline);

    }


    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","512412");
        jsonObject.put("code2","123");
//        System.out.println(JSON.toJSON(jsonObject));
        String s = "{ \"code\", \"12345\"}";
        JSON.toJSON(s);
        System.out.println(s);
        try {
//            send(jsonObject, "15251800012");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}