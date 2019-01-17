package com.example.mytestdemo;

import com.example.mytestdemo.demo.ThreadClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MytestdemoApplicationTests {

    @Test
    public void contextLoads() {
        ThreadClass threadClass=new ThreadClass();
        threadClass.run();
    }

}

