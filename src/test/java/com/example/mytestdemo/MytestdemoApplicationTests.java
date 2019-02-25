package com.example.mytestdemo;

import com.example.mytestdemo.demo.HeelloRunnable;
import com.example.mytestdemo.demo.HelloThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MytestdemoApplicationTests {

    @Test
    public void contextLoads() {
        HelloThread helloThread=new HelloThread();
        //threadClass.run();
        helloThread.start();

    }

    @Test
    public void test(){
        Thread thread=new Thread(new HeelloRunnable());
        thread.start();
    }

}

