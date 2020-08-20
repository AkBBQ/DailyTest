package com.example.mytestdemo.HighJavaDemo.IO.PDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 将图片拼接成pdf
 */

public class imageUtil {

    /**
     * 将远程文件转换成字节数组
     *
     * @param path
     * @return
     */
    public static byte[] getImgToBytes(String path) {
        URL url;
        try {
            url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream in = conn.getInputStream();
            byte[] data = readInputStream(in);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件转换成字节数组异常" + e);
        }
    }

    public static byte[] readInputStream(InputStream ins) throws IOException {
        // TODO 自动生成的方法存根
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = ins.read(buffer)) != -1) {
            out.write(buffer, 0, len);

        }
        ins.close();

        return out.toByteArray();
    }

    /**
     * 合并二个byte数组
     *
     * @param byte1
     * @param byte2
     * @return
     */
    public static byte[] mergeTwoByte(byte[] byte1, byte[] byte2) {
        byte[] byte3 = new byte[byte1.length + byte2.length];
        System.arraycopy(byte1, 0, byte3, 0, byte1.length);
        System.arraycopy(byte2, 0, byte3, byte1.length, byte2.length);
        return byte3;
    }


    /**
     * 网络地址图片转pdf byte数组
     *
     * @param urlPath
     * @return
     */
    public static byte[] creatPdfByte(List<String> urlPath) {
        try {
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, byteArray);
            document.open();
            float maxWith = 500;
            //图片远程地址
            for (String imgUrl : urlPath) {
                Jpeg jpeg = new Jpeg(getImgToBytes(imgUrl));
                jpeg.setAlignment(Image.MIDDLE);
                float width = jpeg.getWidth();
                float height = jpeg.getHeight();
                if (width > maxWith) {
                    jpeg.scaleAbsoluteWidth(maxWith);
                    jpeg.scaleAbsoluteHeight(height * maxWith / width);
                }
                document.add(jpeg);
            }
            document.close();

            // 存入文件
//            File file = new File("/Users/angtai/dev/myTest.pdf");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            byteArray.writeTo(new FileOutputStream(file));
            return byteArray.toByteArray();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException("图片转成pdf异常", e);
        }
    }


    public static void main(String[] args) {
        List<String> images = new ArrayList<>();
        images.add("https://t8.baidu.com/it/u=3571592872,3353494284&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1586416674&t=55f1c5a3241e897e08855f39df82e07e");
        images.add("https://t8.baidu.com/it/u=1484500186,1503043093&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1586416674&t=6320f5bebe93c201361d85b2250f2008");
        images.add("https://t7.baidu.com/it/u=3204887199,3790688592&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1586416674&t=ab1043d2c4e2ebc26e50bb7765bf1944");
        images.add("https://t9.baidu.com/it/u=583874135,70653437&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1586416674&t=2a83606b373cdd073c20b4a56150a016");
        creatPdfByte(images);
    }
}