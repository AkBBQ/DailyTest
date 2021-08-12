package com.example.mytestdemo;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class EsTest extends BaseTest {

    @Qualifier("esRestClient")
    @Autowired
    private RestHighLevelClient client;

    @Test
    public void testES() {
        System.out.println(client);
    }


}

