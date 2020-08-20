package com.example.mytestdemo.HighJavaDemo.httpClient;

import com.alibaba.fastjson.JSONObject;
import com.example.mytestdemo.Model.Student;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2020/4/15.
 */
public class httpClientDemo {

    public void testGet(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        List<NameValuePair> studentList = new ArrayList<>();
        studentList.add(new BasicNameValuePair("id","1"));
        studentList.add(new BasicNameValuePair("name","hzr"));
        studentList.add(new BasicNameValuePair("age","23"));

        URI uri = null;
        try {
            uri = new URIBuilder().setScheme("com/example/mytestdemo/HighJavaDemo/http").setHost("127.0.0.1")
                    .setPort(123).setPath("/test").setParameters(studentList).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpGet get = new HttpGet(uri);

        CloseableHttpResponse response =null;
        try {
            response = httpClient.execute(get);
            HttpEntity httpEntity = response.getEntity();
            System.out.println(response.getStatusLine());
            System.out.println(httpEntity.getContent());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testPost(){

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        URI uri = null;
        try {
            uri = new URIBuilder().setScheme("com/example/mytestdemo/HighJavaDemo/http").setHost("127.0.0.1")
                    .setPort(123).setPath("/test").build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpPost post = new HttpPost(uri);
        Student student = new Student(1,"hzr",23);
        StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(student),"UTF-8");
        post.setEntity(stringEntity);
        post.setHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response =null;
        try {
            response = httpClient.execute(post);
            HttpEntity httpEntity = response.getEntity();
            System.out.println(response.getStatusLine());
            System.out.println(httpEntity.getContent());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
