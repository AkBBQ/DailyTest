package com.example.mytestdemo.Utils;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunjie
 */
public class FileUtils {
    private static String filePath = "tradeDetail.txt__123";

    private static void read(String filePath) {
        Resource resource = new ClassPathResource(filePath);
        try {
            File file = resource.getFile();

            FileInputStream fileInputStream = new FileInputStream(file);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String content = null;

            List<String[]> lists = new ArrayList<>();
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
                String[] split = content.split(",");
                lists.add(split);
            }
            if (CollectionUtils.isNotEmpty(lists)){}
            for (String[] list : lists){
                int i = 0;
                while (i<list.length){
                    System.out.println(list[i]);
                    i++;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read(FileUtils.filePath);
    }

}
