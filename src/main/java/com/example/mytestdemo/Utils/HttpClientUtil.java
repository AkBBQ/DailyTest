package com.example.mytestdemo.Utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * HttpClient工具类
 */
public class HttpClientUtil {
    public static final int CONNECTION_TIMEOUT = 5000;// 连接超时时间
    public static final int CONNECTION_REQUEST_TIMEOUT = 5000;// 请求超时时间
    public static final int SOCKET_TIMEOUT = 10000;// 数据读取等待超时
    public static final String HTTP = "http";// http
    public static final String HTTPS = "https";// https
    public static final int DEFAULT_HTTP_PORT = 80;// http端口
    public static final int DEFAULT_HTTPS_PORT = 443;// https端口
    public static final String DEFAULT_ENCODING = "UTF-8";// 默认编码
    private static Log log = LogFactory.getLog(HttpClientUtil.class);

    /**
     * get请求(1.处理http请求;2.处理https请求,信任所有证书)[默认编码:UTF-8]
     *
     * @param url (参数直接拼接到URL后面，即http://test.com?a=1&b=2的形式)
     * @return
     */
    public static String get(String url) {
        return get(url, null, DEFAULT_ENCODING);
    }

    /**
     * get请求(1.处理http请求;2.处理https请求,信任所有证书)[默认编码:UTF-8]
     *
     * @param url    (url不带参数，例：http://test.com)
     * @param reqMap (参数放置到一个map中)
     * @return
     */
    public static String get(String url, Map<String, String> reqMap) {
        return get(url, reqMap, DEFAULT_ENCODING);
    }

    /**
     * get请求(1.处理http请求;2.处理https请求,信任所有证书)
     *
     * @param url      (只能是http或https请求)
     * @param encoding
     * @return
     */
    public static String get(String url, Map<String, String> reqMap, String encoding) {
        String result = "";
        if (StringUtils.isBlank(url)) {
            log.info("----->url为空");
            return result;
        }

        // 处理参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (reqMap != null && reqMap.keySet().size() > 0) {
            Iterator<Map.Entry<String, String>> iter = reqMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entity = iter.next();
                params.add(new BasicNameValuePair(entity.getKey(), entity.getValue()));
            }
        }

        CloseableHttpClient httpClient = null;
        if (url.startsWith(HTTPS)) {
            // 创建一个SSL信任所有证书的httpClient对象
            httpClient = HttpClientUtil.sslClient();
        } else {
            httpClient = HttpClients.createDefault();
        }

        CloseableHttpResponse response = null;
        HttpGet httpGet = null;

        try {
            if (params != null && params.size() > 0) {
                URIBuilder builder = new URIBuilder(url);
                builder.setParameters(params);
                httpGet = new HttpGet(builder.build());
            } else {
                httpGet = new HttpGet(url);
            }

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(CONNECTION_TIMEOUT)   //设置连接超时时间
                    .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT) // 设置请求超时时间
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .setRedirectsEnabled(true)//默认允许自动重定向
                    .build();
            httpGet.setConfig(requestConfig);

            // 发送请求，并接收响应
            response = httpClient.execute(httpGet);

            result = handleResponse(url, encoding, response);
        } catch (Exception e) {
            log.error("----->url:" + url + ", get请求异常:" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResource(httpClient, response);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=035fbe324d53459e88448b76723206fe",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=0728a984b04d4790ab04812151bcbe56",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=0cd6be3d49d94277b5b732dd1a4c18c6",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=10396be20c024ca485b16a86f0b092f6",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=1323395a8f4b4d1aa07105b0fbdc91b3",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=157fc3724a4740839db7800f955cdb1c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=17a3ec5ca4b045c387a548a8ac4ad2f9",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=192a3c1fd5dd4b9b9b4178454eec52f6",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=1b722e59a50447f8a7a4333697e2da4e",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=1d63852ced1d47f3ab6c77678686975c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=1de2e5f675fb4beda46b15311a542fe7",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=1df59fd3b38048f0a66be9cb50c249c4",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=21c30c2b365e448faf3e71b34465bfbb",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=24ceae90234143a9bef34124ee6e63e2",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=25f96a7822c641aa9c7c23b1afea2cf1",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=280de15f92874852a2230722427fd034",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=2ca2164da91e4541b9ccc62b3c77d797",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=2cb7d467fd744a4eb4fd60a9f8dbd121",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=2cd910f1c4804a288e12e8585d9c184b",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=31477c97859643e195a6f256f1fb61d1",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=3165b6fce42d4b6db8f8d5aa2aab5129",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=3312c33a8e014ff08e2345675f816222",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=3825adc9b9f74febbaff068f817dc491",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=394c8f8af43b4cdf85dce7505a976f7c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=4257cf1e07b64df992f30372730d5cc1",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=45479b54f78a49af875d3f4eff67fcd5",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=46aea8a094404a9391cb318f6dfed895",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=49ff7f5cabc24129b896d16bda225f4c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=4d17e30aa38942f3bfd5547360a67b74",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=4f264c570b0c40eb89eff78cbb7831c7",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=4fea1a5418084fa1a50a25cb1f4fb3be",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=515a2263a39e44c1bdbc734769fcf95c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=5204e97b16a94811b441ecb1f15b6914",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=54a5c179cf954c8d986e0c894c19617e",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=559b2515b0ab45b3912c0aa913232565",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=5b8c34d07a1549fd8ffc19123f70198f",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=5d8331f05e7a49baa750fc2480a1718e",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=5dad23ee2f664d24b5d6be532a0f938d",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=61cad7d905e44efba411f2eb681c45f4",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=67bb72a46a3b476989da633fd3344278",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=6c2b00797cae46cdba3e941fc475ee3b",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=6db5f2d3cacb4f7fad471a36e26b593c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=6f65f7e674e54d228c0566f34ba98a43",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=7059a130cd7a4cee92c73a1769d6568b",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=73fd310fc34b434abcaba6a663b43923",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=79cb59a29fd64bb09bfb6bc38a40954f",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=7b976c6177db4e36a005e6c465e5205b",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=7d9dbf32c1b14673a2a568b24909a5c9",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=8258c71e5e684c7a8288428fcfd7550e",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=8282bc41ba5947e2abdf7351cbf3fc20",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=881e38abe9c449e9b8085e55931753f5",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=88c4b4eee31d4684bd93d3bf8cd63179",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=8a734ed80bc540bc9774c0dd6aadb1f3",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=8e776e351914426780a1d1e1c523181a",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=8f3d540975eb4b7daccfd16d98b77ddb",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=9041965bc040401c9d32dd3460e8dd22",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=919fdc096f674cdeb25b6f0827d5b890",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=91c8d04608ab468199b002b1aac34531",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=9772991a67774a8baddbcc7482f24bf8",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=9ab6f675e5054deb84291fcc868517a9",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=9b8c0af9ad7947d4a0e772446b0853a4",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=9c2d8461b749485cbcc6dbda7d2bc7ff",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=9d9273e50ff645cabcee1c44763a9124",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=a44e75559da8463a9e0f36369d2a4bab",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=a62b16f589214b0dad86e5cf21bc22cc",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=adbca9cb155c4195bd3a49c1afd7d86c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=b8fbfa96e55f4a4e87eb81a974a8f0a6",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=c450fd085585496dafa1d062b4950b54",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=c4f0dcf36ae64702ba11632344584a5c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=cc1ce427a72e48e284faf24938cfc4dc",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=cf9456ac96304a6195d07a24f3dac67e",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=d0c263785de742a68028ceffca21bedf",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=d82785cfa8ae4937a7c95a05ae540ff5",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=db2f7476f65742e69c258d12b728f7e1",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=dd5612861a6649e99e8aa3d099f238a7",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=e26581f47ad84045a539d1cecd683ced",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=eb3998540f064314985879a735f6af3c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=ecea1e97945144e9b8009a3ed195021c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=f2db369d9e544f3280751828f6ccbe3c",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=f4b953ce39b14ad99d94e8ab1c61019f",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=f55556c3cc54403a96de924ef0800c25",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=f6ef12b2d76548a6b539b6b231991798",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=fab284889c9b4ca09b446d1908b9fba1",
                "https://cloudfund-api.hd123.com/pay-cloudfund-server/dev/retry/commision?merchantUuid=202204290001&settleOrderUuid=ff198cc9fa5e49d392a07a744415a50b"

        );

        int size = 0;
        for (String url : urls){
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            String result = get(url);
            System.out.println(result);
            size++;
            System.out.println("处理好第:"+size);
        }


    }


    /**
     * post请求(1.处理http请求;2.处理https请求,信任所有证书)[默认编码:UTF-8]
     *
     * @param url
     * @param reqMap
     * @return
     */
    public static String post(String url, Map<String, String> reqMap) {
        return post(url, reqMap, DEFAULT_ENCODING);
    }

    /**
     * post请求(1.处理http请求;2.处理https请求,信任所有证书)
     *
     * @param url
     * @param reqMap   入参是个map
     * @param encoding
     * @return
     */
    public static String post(String url, Map<String, String> reqMap, String encoding) {
        String result = "";
        if (StringUtils.isBlank(url)) {
            log.info("----->url为空");
            return result;
        }

        // 添加参数
        List<NameValuePair> params = new ArrayList<>();
        if (reqMap != null && reqMap.keySet().size() > 0) {
            Iterator<Map.Entry<String, String>> iter = reqMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entity = iter.next();
                params.add(new BasicNameValuePair(entity.getKey(), entity.getValue()));
            }
        }

        CloseableHttpClient httpClient = null;
        if (url.startsWith(HTTPS)) {
            // 创建一个SSL信任所有证书的httpClient对象
            httpClient = HttpClientUtil.sslClient();
        } else {
            httpClient = HttpClients.createDefault();
        }
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(CONNECTION_TIMEOUT)   //设置连接超时时间
                    .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT) // 设置请求超时时间
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .setRedirectsEnabled(true)//默认允许自动重定向
                    .build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpPost.setEntity(new UrlEncodedFormEntity(params, encoding));

            // 发送请求，并接收响应
            response = httpClient.execute(httpPost);
            result = handleResponse(url, encoding, response);
        } catch (IOException e) {
            log.error("-----> url:" + url + ",post请求异常:" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResource(httpClient, response);
        }

        return result;
    }

    /**
     * post请求(1.处理http请求;2.处理https请求,信任所有证书)
     *
     * @param url
     * @param jsonParams 入参是个json字符串
     * @param encoding
     * @return
     */
    public static String post(String url, String jsonParams, String encoding) {
        String result = "";
        if (StringUtils.isBlank(url)) {
            log.info("----->url为空");
            return result;
        }

        CloseableHttpClient httpClient = null;
        if (url.startsWith(HTTPS)) {
            // 创建一个SSL信任所有证书的httpClient对象
            httpClient = HttpClientUtil.sslClient();
        } else {
            httpClient = HttpClients.createDefault();
        }
        CloseableHttpResponse response = null;

        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(CONNECTION_TIMEOUT)   //设置连接超时时间
                    .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT) // 设置请求超时时间
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .setRedirectsEnabled(true)//默认允许自动重定向
                    .build();
            httpPost.setConfig(requestConfig);

            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(jsonParams, ContentType.create("application/json", encoding)));

            // 发送请求，并接收响应
            response = httpClient.execute(httpPost);
            result = handleResponse(url, encoding, response);
        } catch (IOException e) {
            log.error("-----> url:" + url + ",post请求异常:" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResource(httpClient, response);
        }

        return result;
    }

    /**
     * 创建一个SSL信任所有证书的httpClient对象
     *
     * @return
     */
//    public static CloseableHttpClient createSSLInsecureClient() {
//        try {
//            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
//                // 默认信任所有证书
//                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//                    return true;
//                }
//            }).build();
//
//            SSLConnectionSocketFactory sslcsf = new SSLConnectionSocketFactory(sslContext);
//
//            return HttpClients.custom().setSSLSocketFactory(sslcsf).build();
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        }
//
//        return HttpClients.createDefault();
//    }

    /**
     * 处理响应，获取响应报文
     * sun
     * jie
     * 哈哈哈
     *
     * @param url
     * @param encoding
     * @param response
     * @return
     * @throws IOException
     */
    private static String handleResponse(String url, String encoding, CloseableHttpResponse response) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        try {
            if (response != null) {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();

                    if (entity != null) {
                        br = new BufferedReader(new InputStreamReader(entity.getContent(), encoding));
                        String s = null;
                        while ((s = br.readLine()) != null) {
                            sb.append(s);
                        }
                    }

                    // 释放entity
                    EntityUtils.consume(entity);
                } else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                    log.info("-----> get请求404,未找到资源. url:" + url);
                } else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                    log.info("-----> get请求500,服务器端异常. url:" + url);
                }
            }
        } catch (Exception e) {
            log.error("----->url:" + url + ",处理响应，获取响应报文异常：" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    /**
     * 释放资源
     *
     * @param httpClient
     * @param response
     */
    private static void closeResource(CloseableHttpClient httpClient, CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                log.error("-----> 释放response资源异常:" + e.getMessage());
                e.printStackTrace();
            }
        }

        if (httpClient != null) {
            try {
                httpClient.close();
            } catch (Exception e) {
                log.error("-----> 释放httpclient资源异常:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }


    /**
     * 采用绕过验证的方式处理https请求
     *
     * @param url
     * @param reqMap
     * @param encoding
     * @return
     */
    public static String postSSLUrl(String url, Map<String, String> reqMap, String encoding) {
        String result = "";
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        // 添加参数
        List<NameValuePair> params = new ArrayList<>();
        if (reqMap != null && reqMap.keySet().size() > 0) {
            Iterator<Map.Entry<String, String>> iter = reqMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entity = iter.next();
                params.add(new BasicNameValuePair(entity.getKey(), entity.getValue()));
            }
        }

        try {

            httpClient = HttpClientUtil.sslClient();

            //创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params, encoding));

            //指定报文头Content-type、User-Agent
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            //httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

            //执行请求操作，并拿到结果（同步阻塞）
            response = httpClient.execute(httpPost);
            result = handleResponse(url, encoding, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(httpClient, response);
        }

        return result;
    }


    /**
     * 在调用SSL之前需要重写验证方法，取消检测SSL
     * 创建ConnectionManager，添加Connection配置信息
     *
     * @return HttpClient 支持https
     */
    private static CloseableHttpClient sslClient() {
        try {
            // 在调用SSL之前需要重写验证方法，取消检测SSL
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String str) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String str) {
                }
            };
            SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            ctx.init(null, new TrustManager[]{trustManager}, null);
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
            // 创建Registry
            RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
                    .setExpectContinueEnabled(Boolean.TRUE).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                    .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", socketFactory).build();
            // 创建ConnectionManager，添加Connection配置信息
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            CloseableHttpClient closeableHttpClient = HttpClients.custom().setConnectionManager(connectionManager)
                    .setDefaultRequestConfig(requestConfig).build();
            return closeableHttpClient;
        } catch (KeyManagementException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}