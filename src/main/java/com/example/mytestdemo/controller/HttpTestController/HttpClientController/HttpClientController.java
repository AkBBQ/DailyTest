package com.example.mytestdemo.controller.HttpTestController.HttpClientController;

import com.alibaba.fastjson.JSON;
import com.example.mytestdemo.controller.HttpTestController.FeignController.domain.CrmMember;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * HttpClients 请求demo
 * @author sunjie
 */

@RestController
public class HttpClientController {


    @RequestMapping("httpClient")
    public void ss() throws IOException {


        CrmMember crmMember = new CrmMember();
        crmMember.setName("23");
        crmMember.setAge(23);

        String request = JSON.toJSONString(crmMember);
        CloseableHttpClient client = null;
        String response = StringUtils.EMPTY;
        try {
            client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost:8080/third/server/add/member");
            StringEntity strEntity = new StringEntity(request);
            httpPost.setEntity(strEntity);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(20000)
                    .setConnectTimeout(20000).build();
            httpPost.setConfig(requestConfig);

            httpPost.setHeader("accept", "*/*");
            httpPost.setHeader("connection", "Keep-Alive");
            httpPost.setHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");

            CloseableHttpResponse httpResponse = client.execute(httpPost);

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode < 200 || statusCode > 300) {
                throw new RuntimeException();
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                response = EntityUtils.toString(entity, "utf-8");
                System.out.println(response);
            }
        } catch (Exception e) {
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                }
            }
        }

    }
}
