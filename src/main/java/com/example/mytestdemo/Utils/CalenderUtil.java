package com.example.mytestdemo.Utils;

import java.util.Calendar;
import java.util.Date;

public class CalenderUtil {


    public static void main(String[] args) {

        //一：获取Calender的时间
        Calendar c1 = Calendar.getInstance();

        Date time = c1.getTime();
        System.out.println(time);

        System.out.println("年:" + c1.get(Calendar.YEAR));
        //月份是从0开始 需要+1
        System.out.println("月:" + (c1.get(Calendar.MONTH) + 1));
        System.out.println("日:" + c1.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + c1.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + c1.get(Calendar.MINUTE));
        System.out.println("秒:" + c1.get(Calendar.SECOND));

        //二:自己设置具体时间
        Calendar c2 = Calendar.getInstance();
        c2.set(2018, 2, 6, 13, 22, 21);
        System.out.println("自己设置的时间为:" + c2.getTime());

        //三:操作时间
        //加一年
        c2.add(Calendar.YEAR,1);
        c2.add(Calendar.SECOND,9);
        System.out.println(c2.getTime());
    }
}
