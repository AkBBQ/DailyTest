package com.example.mytestdemo.Utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.Document;

import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

/**
 * 将多个pdf
 */

public class PDFMergeUtils {


    public static List<byte[]> getPdfBytes(List<String> urls) throws IOException {

        List<byte[]> list = new ArrayList<>();

        for (String u : urls) {
            URL url = new URL(u);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3 * 1000);
            //防止屏蔽程序抓取而返回403错误
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            //得到输入流
            InputStream inputStream = connection.getInputStream();

            //将读到的文件转成byte数组

            byte[] readBuffer = new byte[1024];
            int len = 0;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(readBuffer)) != -1) {
                byteArrayOutputStream.write(readBuffer, 0, len);
            }
            byteArrayOutputStream.close();

            //读到的文件内容
            byte[] readBytes = byteArrayOutputStream.toByteArray();
            list.add(readBytes);

        }
        return list;
    }


    public static byte[] mix(List<byte[]> bytes) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Document document = new Document();// 创建一个新的PDF
        PdfCopy copy = new PdfCopy(document, bos);
        document.open();
        for (byte[] bs : bytes) {// 取出单个PDF的数据
            PdfReader reader = new PdfReader(bs);
            int pageTotal = reader.getNumberOfPages();
            System.out.println("pdf的页码数是 ==>" + pageTotal);
            for (int pageNo = 1; pageNo <= pageTotal; pageNo++) {
                document.newPage();
                PdfImportedPage page = copy.getImportedPage(reader, pageNo);
                copy.addPage(page);
            }
            reader.close();
        }
        document.close();
        byte[] pdfs = bos.toByteArray();
        bos.close();
        copy.close();
        return pdfs;
    }


    public static void saveFile( String fileName, String savePath,byte[] bytes) throws IOException {
        //文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        //创建文件
        File file = new File(saveDir + File.separator + fileName);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.close();

    }

    public static void main(String[] args) throws Exception {
        List<String> strings = Arrays.asList("https://secure.maihaoche.com/20210121%E6%88%90%E9%83%BD%E8%B6%85%E6%9C%89%E7%88%B1%E7%A7%91%E6%8A%80-%E4%BB%A3%E9%87%87%E5%A5%A5%E8%BF%AAA5%202020%E6%AC%BE%20Coupe%2040%20TFSI%20%E6%97%B6%E5%B0%9A%E5%9E%8B%20%E5%9B%BDVI%E7%AD%8960.768%E4%B8%87.pdf?e=1613889774&token=BzDkpyEeUNKVhvJn5spXnnwzQXYBnS034DXkbP3U:q9HsPPymXt-U_GxrZIcYnfTKIUM=", "https://secure.maihaoche.com/20210121%E6%88%90%E9%83%BD%E8%B6%85%E6%9C%89%E7%88%B1%E7%A7%91%E6%8A%80-%E4%BB%A3%E9%87%87%E5%A5%A5%E8%BF%AAA5%202020%E6%AC%BE%20Coupe%2040%20TFSI%20%E6%97%B6%E5%B0%9A%E5%9E%8B%20%E5%9B%BDVI%E7%AD%8960.768%E4%B8%87.pdf?e=1613889774&token=BzDkpyEeUNKVhvJn5spXnnwzQXYBnS034DXkbP3U:q9HsPPymXt-U_GxrZIcYnfTKIUM=", "https://secure.maihaoche.com/20210121%E6%88%90%E9%83%BD%E8%B6%85%E6%9C%89%E7%88%B1%E7%A7%91%E6%8A%80-%E4%BB%A3%E9%87%87%E5%A5%A5%E8%BF%AAA5%202020%E6%AC%BE%20Coupe%2040%20TFSI%20%E6%97%B6%E5%B0%9A%E5%9E%8B%20%E5%9B%BDVI%E7%AD%8960.768%E4%B8%87.pdf?e=1613889774&token=BzDkpyEeUNKVhvJn5spXnnwzQXYBnS034DXkbP3U:q9HsPPymXt-U_GxrZIcYnfTKIUM=");
        saveFile("haha.pdf","/Users/angtai/dev/FileTest/PDFDemo",mix(getPdfBytes(strings)));

    }


}
