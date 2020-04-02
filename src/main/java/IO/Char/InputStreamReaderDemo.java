package IO.Char;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * FileInputStrem，它是一个字节流，读取的单位是byte，
 *
 * 我们看它的参数中是可以传入byte类型数据的，
 *
 * 而对于InputStremReader，它所不同的就是传入的参数从byte编程char了，
 *
 * 这就是两者的区别，由此我们使用InputStremReader就可以读取中文了，
 *
 * 因为一个汉字占两个字节，而char就是两个字节
 *
 */

public class InputStreamReaderDemo {

    public static void main(String[] args) throws Exception {

        File file = new File("/Users/angtai/dev/FileTest/charTest.txt");
        if(!file.exists()){
           file.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream(file);

        //这个InputStremReader是需要传入一个字节流的，InputStremReader是比较特殊的，它可以传入编码格式
        InputStreamReader inputStreamReader  = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

        char[] chars = new char[64];
        int read = inputStreamReader.read(chars);

        String content = new String(chars);

        System.out.println("文件中的内容为:"+content);
    }
}