package com.example.mytestdemo.Utils;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    private static long oneDayTimes = (1000 * 60 * 60 * 24) * 1;


    private static String yyyMMDD = "yyyy-MM-dd";
    private static String yyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    private static String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    /**
     * 判断是否跨天
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean isMoreOneDay(Date startDate, Date endDate) {

        long dayResult = endDate.getTime() - startDate.getTime();
        if (dayResult > dayResult) return true;
        return false;
    }


    public static String formatToDateStart(String start) throws ParseException {
        if (null == start) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sf.parse(start);
        start = sf.format(startDate);
        return start + " 00:00:00";
    }

    public static String formatToDateEnd(String end) throws ParseException {
        if (null == end) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sf.parse(end);
        end = sf.format(startDate);
        return end + " 23:59:59";
    }

    public int getDays(String start, String end) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = sf.parse(start);
        Date endDate = sf.parse(end);
        long day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        return new Long(day).intValue() + 1;
    }

    // 获取下一天
    public String getNextDate(String date) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(yyMMddHHmmss);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sf.parse(date));
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day + 1);
        Date date1 = new Date(calendar.getTimeInMillis());
        return sf.format(date1);
    }

    /**
     * s
     * 获取当前时间
     */
    public static String getCurrentTime(Date date) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(yyyyMMddHHmmss);
        return sf.format(date);
    }

    /**
     * 格式化日期
     *
     * @param parse 解析格式 yyyyMMddHHmmssSSS
     * @return formatDate-parse
     */
    public static String formatDate(String parse) {
        SimpleDateFormat sdf = new SimpleDateFormat(parse);
        return sdf.format(new Date());
    }

    /**
     * 时间拆分函数
     *
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public String[][] breakUpDays(String start, String end) throws ParseException {
        int days = getDays(start, end);
        String[][] daySet = new String[days][2];
        String nextDate = start;
        for (int i = 0; i < days; i++) {
            daySet[i][0] = formatToDateStart(nextDate);
            daySet[i][1] = formatToDateEnd(nextDate);
            nextDate = getNextDate(nextDate);
        }
        daySet[0][0] = start;
        daySet[days - 1][1] = end;
        return daySet;
    }

    /**
     * 获得输入的起始时间和结束时间在该月里的号数集合。
     *
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public int[] getDayOfMonth(String start, String end) throws ParseException {
        int days = getDays(start, end);
        //String[] daySet = new String[days];
        int[] daySet = new int[days];
        String nextDate = start;
        for (int i = 0; i < days; i++) {
            //daySet[i][0] = formatToDateStart(nextDate);
            daySet[i] = Integer.parseInt(nextDate.substring(8, 10));
            nextDate = getNextDate(nextDate);
        }
        //daySet[0] = start;
        return daySet;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个字符串日期之间相差的天数
     *
     * @param smdate
     * @param bdate
     * @return
     * @throws ParseException
     */
    public static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 加减秒数
     *
     * @param date
     * @param seconds
     * @return
     * @throws ParseException
     */
    public static String addSeconds(Date date, int seconds, String patten) {
        //结束时间为当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return new SimpleDateFormat(patten).format(calendar.getTime());
    }


    public static void main(String[] args) throws Exception {

        String startTime = "2021-07-06 09:20:30";
        System.out.println(dayForWeek(startTime));

    }


    /**
     * 判断一个星期是星期几
     *
     * @param pTime
     * @return
     * @throws Exception
     */
    public static String dayForWeek(String pTime) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        c.setTime(simpleDateFormat.parse(pTime));

        int dayForWeek = 0;

        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;

        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;

        }

        return DayEnum.getDesc(dayForWeek);

    }

    public enum DayEnum {
        星期一(1, "星期一"),
        星期二(2, "星期二"),
        星期三(3, "星期三"),
        星期四(4, "星期四"),
        星期五(5, "星期五"),
        星期六(6, "星期六"),
        星期日(7, "星期日");


        private Integer day;
        private String dayDesc;

        public Integer getDay() {
            return day;
        }

        public void setDay(Integer day) {
            this.day = day;
        }

        public String getDayDesc() {
            return dayDesc;
        }

        public void setDayDesc(String dayDesc) {
            this.dayDesc = dayDesc;
        }

        DayEnum() {
        }

        DayEnum(Integer day, String dayDesc) {
            this.day = day;
            this.dayDesc = dayDesc;
        }

        public static String getDesc(int day) {
            for (DayEnum d : DayEnum.values()) {
                if (d.day == day) {
                    return d.dayDesc;
                }
            }
            return "";
        }

    }

}
