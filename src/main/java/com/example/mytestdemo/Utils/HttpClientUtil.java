package com.example.mytestdemo.Utils;

import org.apache.commons.lang.StringUtils;
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