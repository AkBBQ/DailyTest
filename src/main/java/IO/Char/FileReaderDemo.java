package IO.Char;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package IO.Char
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/4/2 1:29 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class FileReaderDemo {
    public static void main(String[] args) {
        File file = new File("/Users/angtai/dev/FileTest/charTest.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileReader fileReader = new FileReader(file);
            char[] chars = new char[64];

            int read = fileReader.read(chars);

            String ss = new String(chars);
            System.out.println(ss);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}