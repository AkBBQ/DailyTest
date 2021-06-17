package com.example.mytestdemo.Utils;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Excel 工具
 * 版权声明：本文为CSDN博主「小白逆流而上」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/baidu_39298625/article/details/105842725
 */
public class ExcelUtils {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    private static final String XLS = ".xls";
    private static final String XLSX = ".xlsx";

    /**
     * 根据文件后缀获取对应Workbook对象
     *
     * @param filePath
     * @param fileType
     * @return
     */
    public static Workbook getWorkbook(String filePath, String fileType) {
        Workbook workbook = null;
        FileInputStream fileInputStream = null;
        try {
            File excelFile = new File(filePath);
            if (!excelFile.exists()) {
                logger.info(filePath + "文件不存在");
                return null;
            }
            fileInputStream = new FileInputStream(excelFile);
            if (fileType.equalsIgnoreCase(XLS)) {
                workbook = new HSSFWorkbook(fileInputStream);
            } else if (fileType.equalsIgnoreCase(XLSX)) {
                workbook = new XSSFWorkbook(fileInputStream);
            }
        } catch (Exception e) {
            logger.error("获取文件失败", e);
        } finally {
            try {
                if (null != fileInputStream) {
                    fileInputStream.close();
                }
            } catch (Exception e) {
                logger.error("关闭数据流出错！错误信息：", e);
                return null;
            }
        }
        return workbook;
    }

    public static List<Object> readFolder(String filePath) {
        int fileNum = 0;
        File file = new File(filePath);
        List<Object> returnList = new ArrayList<>();
        List<Map<String, String>> resultList = new ArrayList<>();
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isFile()) {
                    resultList = readExcel(file2.getAbsolutePath());
                    returnList.add(resultList);
                    fileNum++;
                }
            }
        } else {
            logger.info("文件夹不存在");
            return null;
        }
        logger.info("共有文件：" + fileNum);
        return returnList;
    }

    /**
     * 批量读取Excel文件，返回数据对象
     *
     * @param filePath
     * @return
     */
    public static List<Map<String, String>> readExcel(String filePath) {
        Workbook workbook = null;
        List<Map<String, String>> resultList = new ArrayList<>();
        try {
            String fileType = filePath.substring(filePath.lastIndexOf("."));
            workbook = getWorkbook(filePath, fileType);
            if (workbook == null) {
                logger.info("获取workbook对象失败");
                return null;
            }
            resultList = analysisExcel(workbook);
            return resultList;
        } catch (Exception e) {
            logger.error("读取Excel文件失败" + filePath + "错误信息", e);
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
            } catch (Exception e) {
                logger.error("关闭数据流出错！错误信息：", e);
                return null;
            }

        }
    }

    /**
     * 解析Excel文件，返回数据对象
     *
     * @param workbook
     * @return
     */
    public static List<Map<String, String>> analysisExcel(Workbook workbook) {
        List<Map<String, String>> dataList = new ArrayList<>();
        int sheetCount = workbook.getNumberOfSheets();//或取一个Excel中sheet数量
        for (int i = 0; i < sheetCount; i++) {
            Sheet sheet = workbook.getSheetAt(i);

            if (sheet == null) {
                continue;
            }
            int firstRowCount = sheet.getFirstRowNum();//获取第一行的序号
            Row firstRow = sheet.getRow(firstRowCount);
            int cellCount = firstRow.getLastCellNum();//获取列数

            List<String> mapKey = new ArrayList<>();

            //获取表头信息，放在List中备用
            if (firstRow == null) {
                logger.info("解析Excel失败，在第一行没有读取到任何数据！");
            } else {
                for (int i1 = 0; i1 < cellCount; i1++) {
                    mapKey.add(firstRow.getCell(i1).toString());
                }
            }

            //解析每一行数据，构成数据对象
            int rowStart = firstRowCount + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int j = rowStart; j < rowEnd; j++) {
                Row row = sheet.getRow(j);//获取对应的row对象

                if (row == null) {
                    continue;
                }

                Map<String, String> dataMap = new HashMap<>();
                //将每一行数据转化为一个Map对象
                dataMap = convertRowToData(row, cellCount, mapKey);
                dataList.add(dataMap);
            }
        }
        return dataList;
    }

    /**
     * 将每一行数据转化为一个Map对象
     *
     * @param row       行对象
     * @param cellCount 列数
     * @param mapKey    表头Map
     * @return
     */
    public static Map<String, String> convertRowToData(Row row, int cellCount, List<String> mapKey) {
        if (mapKey == null) {
            logger.info("没有表头信息");
            return null;
        }
        Map<String, String> resultMap = new HashMap<>();
        Cell cell = null;
        for (int i = 0; i < cellCount; i++) {
            cell = row.getCell(i);
            if (cell == null) {
                resultMap.put(mapKey.get(i), "");
            } else {
                resultMap.put(mapKey.get(i), getCellVal(cell));
            }
        }
        return resultMap;
    }

    /**
     * 获取单元格的值
     *
     * @param cel
     * @return
     */
    public static String getCellVal(Cell cel) {
        if (cel.getCellType() == CellType.STRING) {
            return cel.getRichStringCellValue().getString();
        }
        if (cel.getCellType() == CellType.NUMERIC) {
            return cel.getNumericCellValue() + "";
        }
        if (cel.getCellType() == CellType.BOOLEAN) {
            return cel.getBooleanCellValue() + "";
        }
        if (cel.getCellType() == CellType.FORMULA) {
            return cel.getCellFormula() + "";
        }
        return cel.toString();
    }


    /**
     * 输出excel内容
     *
     * @param filepath
     */
    public static void outputExcel(String filepath) {

        try {
            //创建工作簿
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(filepath));
            System.out.println("xssfWorkbook对象：" + xssfWorkbook);
            //读取第一个工作表
            XSSFSheet sheet = xssfWorkbook.getSheetAt(1);

            int numberOfSheets = xssfWorkbook.getNumberOfSheets();
            System.out.println("总共有" + numberOfSheets + "个工作表：");

            System.out.println("sheet对象：" + sheet);
            //获取最后一行的num，即总行数。此处从0开始计数
            int maxRow = sheet.getLastRowNum();
            System.out.println("总行数为：" + maxRow);
            for (int row = 0; row <= maxRow; row++) {
                //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
                int maxRol = sheet.getRow(row).getLastCellNum();
                System.out.println("--------第" + row + "行的数据如下--------");
                for (int rol = 0; rol < maxRol; rol++) {
                    XSSFCell cell = sheet.getRow(row).getCell(rol);

                    System.out.print(sheet.getRow(row).getCell(rol) + "  ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 创建excel内容
     *
     */
    public static void createExcel() {

        try {
            //创建工作薄对象
            XSSFWorkbook workbook=new XSSFWorkbook();//这里也可以设置sheet的Name
            //创建工作表对象
            XSSFSheet sheet = workbook.createSheet();
            //创建工作表的行
            XSSFRow row = sheet.createRow(0);//设置第一行，从零开始
            row.createCell(0).setCellValue("name");//第一行第一列
            row.createCell(1).setCellValue("age");//第一行第二列
            row.createCell(2).setCellValue("phone");//第一行第三列

            XSSFRow row2 = sheet.createRow(1);//设置第二行
            row2.createCell(0).setCellValue("zhangsan");//第二行第一列
            row2.createCell(1).setCellValue("22");//第二行第二列
            row2.createCell(2).setCellValue("15251800012");//第二行第三列

            workbook.setSheetName(0,"sheet1");//设置sheet的Name

            //文档输出
            FileOutputStream out = new FileOutputStream("F:\\Excel\\" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +".xlsx");
            workbook.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        //读取文件夹，批量解析Excel文件
//        System.out.println("--------------------读取文件夹，批量解析Excel文件-----------------------");
//        List<Object> returnList = readFolder("C:\\Users\\Administrator\\Desktop\\ExcelTest");
//        for (int i = 0; i < returnList.size(); i++) {
//            List<Map<String, String>> maps = (List<Map<String, String>>) returnList.get(i);
//            for (int j = 0; j < maps.size(); j++) {
//                System.out.println(maps.get(j).toString());
//            }
//            System.out.println("--------------------手打List切割线-----------------------");
//        }

        //读取单个文件
        System.out.println("--------------------读取并解析单个文件-----------------------");
        List<Map<String, String>> maps = readExcel("F:\\Excel\\执行结果1.xlsx");
        for (int j = 0; j < maps.size(); j++) {
            System.out.println(maps.get(j).toString());
        }


        outputExcel("F:\\Excel\\执行结果1.xlsx");

        createExcel();
    }
}