package com.example.mytestdemo.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 * 
 * @author ouych
 * @date 2015-02-06
 */
public class DateUtils {
	private static String defaultDatePattern = null;
	public static final String MONTH_PATTERN = "yyyy-MM";
	public static final String HOLD_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 返回预设Format的当前日期字符串
	 */
	public static String getTodayStr() {
		Date today = new Date();
		return format(today);
	}
	
	/**
	 * 使用预设Format格式化Date成字符串yyyy-mm-dd
	 */
	public static String format(Date date) {
		return date == null ? "" : format(date, getDatePattern());
	}
	
	/**
	 * 使用参数Format格式化Date成字符串 yyyy-mm-dd
	 */
	public static String format(Date date, String pattern) {
		return date == null ? "" : new SimpleDateFormat(pattern).format(date);
	}
	
	/**
	 * 使用参数Format格式化字符串成Date
	 * @throws ParseException 
	 */
	public static Date parse(String date, String pattern) throws ParseException {
		return new SimpleDateFormat(pattern).parse(date);
	}
	/**
	 * Return default datePattern (yyyy-MM-dd)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {
		try {
			defaultDatePattern = "yyyy-MM-dd";
		} catch (MissingResourceException mse) {
			defaultDatePattern = "yyyy-MM-dd";
		}

		return defaultDatePattern;
	}
	
	public static String formatToDateStart(String date){
		if(null == date){
			return null;
		}
		return date +" 00:00:00";
	}
	
	public static String formatToDateEnd(String date){
		if(null == date){
			return null;
		}
		return date +" 23:59:59";
	}
	
	/**
	 * 时间-天数
	 * @param now
	 * @return
	 */
	public static Date subtracteDay(Date now){
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(now);
		rightNow.add(Calendar.DAY_OF_YEAR, -30);//日期加上分钟数
		Date newDate = rightNow.getTime();
		return newDate;
	}

	/**
	 * 时间-天数
	 * @param time
	 * @param index
	 * @return
	 */
	public static Date subDays(Date time,int index){
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(time);
		rightNow.add(Calendar.DAY_OF_YEAR, -index);
		Date newDate = rightNow.getTime();
		return newDate;
	}
	/**
	 * 时间+天数
	 * @param now
	 * @return
	 */
	public static Date addDays(Date now, int days){
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(now);
		rightNow.add(Calendar.DAY_OF_YEAR, days);//日期加上天数
		Date newDate = rightNow.getTime();
		return newDate;
	}
	/**
	 * 时间+小时
	 * @param now
	 * @return
	 */
	public static Date addHours(Date now, int hours){
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(now);
		rightNow.add(Calendar.HOUR_OF_DAY, hours);//日期加上小时数
		Date newDate = rightNow.getTime();
		return newDate;
	}
	
	/**
	 * @throws ParseException *
	 * 
	 */
	public static boolean getWeekFromTwoDate(String startDate,String endDate,String formate,List<Map<String,Object>> openList) throws ParseException{
		/*List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		SimpleDateFormat sdf=new SimpleDateFormat(formate);
		Date date1=sdf.parse(startDate);
		Date date2=sdf.parse(endDate);
		Calendar c1=Calendar.getInstance();
		c1.setTime(date1);
		long time1 = c1.getTimeInMillis();
		Calendar c2=Calendar.getInstance();
		c2.setTime(date2);
		long time2 = c2.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);
		int dif_dates=Integer.parseInt(String.valueOf(between_days));
		
		for(int i=0;i<=dif_dates;i++){
			Map<String,Object> map=new HashMap<String,Object>();
			Calendar c3=Calendar.getInstance();
			
		}*/
		SimpleDateFormat sdf=new SimpleDateFormat(formate);
		Date date1=sdf.parse(startDate);
		Date date2=sdf.parse(endDate);
		SimpleDateFormat sdf1=new SimpleDateFormat("HHmm");
		int hour1=Integer.parseInt(sdf1.format(date1));
		int hour2=Integer.parseInt(sdf1.format(date2));
		for(int i=0;i<openList.size();i++){
			Map<String,Object> map=openList.get(i);
			int openStartHour=Integer.parseInt(map.get("hour1")+"");
			int openEndHour=Integer.parseInt(map.get("hour2")+"");
			if(hour1<=openStartHour&&hour2>=openEndHour){
				
			}else{
				return false;
			}
			
		}
		
		return true;
	}
	
	/** 
     * 将String型格式化,比如想要将2011-11-11格式化成2011年11月11日,就StringPattern("2011-11-11","yyyy-MM-dd","yyyy年MM月dd日").
     * @param date String 想要格式化的日期
     * @param oldPattern String 想要格式化的日期的现有格式
     * @param newPattern String 想要格式化成什么格式
     * @return String 
     */ 
    public final static String StringPattern(String date, String oldPattern, String newPattern) { 
        if (date == null || oldPattern == null || newPattern == null) 
            return ""; 
        SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern) ;        // 实例化模板对象  
        SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern) ;        // 实例化模板对象  
        Date d = null ;  
        try{  
            d = sdf1.parse(date) ;   // 将给定的字符串中的日期提取出来  
        }catch(Exception e){            // 如果提供的字符串格式有错误，则进行异常处理  
            e.printStackTrace() ;       // 打印异常信息  
        }  
        return sdf2.format(d);
    } 
    
    /** 
     *  
     * 1 第一季度 2 第二季度 3 第三季度 4 第四季度 
     *  
     * @param date 
     * @return 
     */  
    public static int getSeason(Date date) {  
  
        int season = 0;  
  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int month = c.get(Calendar.MONTH);  
        switch (month) {  
        case Calendar.JANUARY:  
        case Calendar.FEBRUARY:  
        case Calendar.MARCH:  
            season = 1;  
            break;  
        case Calendar.APRIL:  
        case Calendar.MAY:  
        case Calendar.JUNE:  
            season = 2;  
            break;  
        case Calendar.JULY:  
        case Calendar.AUGUST:  
        case Calendar.SEPTEMBER:  
            season = 3;  
            break;  
        case Calendar.OCTOBER:  
        case Calendar.NOVEMBER:  
        case Calendar.DECEMBER:  
            season = 4;  
            break;  
        default:  
            break;  
        }  
        return season;  
    }  
    /**
     * 根据时间和季度值获取季度开始时间
     * @param date
     * @param quarter
     * @return
     */
    public static String getQuarterStartTime(Date date,int quarter) {  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
  
        String returnStr = "";  
        try {  
            if (quarter == 1)  
                c.set(Calendar.MONTH, 0);  
            else if (quarter == 2)  
                c.set(Calendar.MONTH, 3);  
            else if (quarter == 3)  
                c.set(Calendar.MONTH, 6);  
            else if (quarter == 4)  
                c.set(Calendar.MONTH, 9);  
            c.set(Calendar.DATE, 1);
            returnStr = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()) + " 00:00:00";
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return returnStr;  
    }  

    
    /** 
     * 根据时间和季度值获取季度结束时间
     * 
     * @return 
     */  
    public static  String getQuarterEndTime(Date date,int quarter) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);  
  
        String returnStr = "";  
        try {  
            if (quarter == 1) {  
                c.set(Calendar.MONTH, 2);  
                c.set(Calendar.DATE, 31);  
            } else if (quarter == 2) {  
                c.set(Calendar.MONTH, 5);  
                c.set(Calendar.DATE, 30);  
            } else if (quarter == 3) {  
                c.set(Calendar.MONTH,8);  
                c.set(Calendar.DATE, 30);  
            } else if (quarter == 4) {  
                c.set(Calendar.MONTH, 11);  
                c.set(Calendar.DATE, 31);  
            }  
            returnStr = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()) + " 23:59:59";
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return returnStr;  
    } 
    
     //需要注意的是：月份是从0开始的，比如说如果输入5的话，实际上显示的是4月份的最后一天
  	 public static String getLastDayOfMonth(int year, int month) {   
           Calendar cal = Calendar.getInstance();   
           cal.set(Calendar.YEAR, year);   
           cal.set(Calendar.MONTH, month);   
           cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
          return  new   SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
       } 
  	 public static String getFirstDayOfMonth(int year, int month) {   
           Calendar cal = Calendar.getInstance();   
           cal.set(Calendar.YEAR, year);   
           cal.set(Calendar.MONTH, month);
           cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
          return   new   SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
       } 
  	 /**
  	  * 获取当前月的下一月份
  	  * @param currentDate 例如：2018-01，下一月份就是2018-02
  	  * @return
  	  */
  	 public static String getNextMonth(String currentDate, String pattern, int months){
  		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			Calendar ct=Calendar.getInstance();
			ct.setTime(df.parse(currentDate));
			ct.add(Calendar.MONTH, months);
			return df.format(ct.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
  	 }
	/**
	 * 获取当前月的上一月份
	 * @param currentDate 例如：2018-02，下一月份就是2018-01
	 * @return
	 */
	public static String getLastMonth(String currentDate, String pattern, int months){
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			Calendar ct=Calendar.getInstance();
			ct.setTime(df.parse(currentDate));
			ct.add(Calendar.MONTH, -months);
			return df.format(ct.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
  	 
  	/**
 	 * 时间+天数
 	 * @param now
 	 * @return
 	 */
 	public static String addMonth(Date now, int months){
 		Calendar rightNow = Calendar.getInstance();
 		rightNow.setTime(now);
 		rightNow.add(Calendar.MONTH, months);//日期加上月份
 		return new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss").format(rightNow.getTime());
 	}
 	
 	/** 
     * 获取上个月日期
     * @param beginDate 
     * @param endDate 
     * @return List 
     */  
    public static Date getPreMonthDate(Date date) { 
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.MONTH, -1);
        return cal.getTime();  
    }
    
    /** 
     * 获取去年当前时间
     * @param beginDate 
     * @param endDate 
     * @return List 
     */  
    public static Date getPreYearDate(Date date) { 
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.YEAR, -1);
        return cal.getTime();  
    }

    public static void main(String[] args) throws ParseException {
		String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		cal.setTime(currentTime);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		weekDays[w] = simpleDateFormat.format(currentTime)+weekDays[w];
		String time = "";
		for(int i=1;i<=w;i++){//往下索引
			cal.setTime(currentTime);
			cal.add(Calendar.DATE,-i);
			if(i==w){
				time = simpleDateFormat.format(cal.getTime());
				System.out.println(simpleDateFormat.format(cal.getTime()));
			}
			weekDays[w-i] = simpleDateFormat.format(cal.getTime())+weekDays[w-i];
		}
		for(int i=6-w;i>0;i--){//往上索引
			cal.setTime(currentTime);
			cal.add(Calendar.DAY_OF_WEEK,i);
			if(i==6-w){
				System.out.println(simpleDateFormat.format(cal.getTime()));
			}
			//System.out.println(simpleDateFormat.format(cal.getTime()));
			weekDays[w+i] = simpleDateFormat.format(cal.getTime())+weekDays[w+i];
		}
		System.out.println(simpleDateFormat.format(subDays(simpleDateFormat.parse(time),7)));

	}



	/**
	 * 获取redis key的时间格式
	 */
	public static String getRedisTimeKey(Date date){
		Calendar  calendar = Calendar.getInstance();
		calendar.setTime(date);
		String minuteString="00";
		String miniSecondInFive="00";
		if(0<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=4){
			miniSecondInFive= "00";
		}
		if(5<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=9){
			miniSecondInFive= "05";
		}if(10<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=14){
			miniSecondInFive= "10";
		}if(15<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=19){
			miniSecondInFive= "15";
		}if(20<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=24){
			miniSecondInFive= "20";
		}if(25<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=29){
			miniSecondInFive= "25";
		}if(30<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=34){
			miniSecondInFive= "30";
		}if(35<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=39){
			miniSecondInFive= "35";
		}if(40<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=44){
			miniSecondInFive= "40";
		}if(45<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=49){
			miniSecondInFive= "45";
		}if(50<=calendar.get(Calendar.SECOND)&&calendar.get(Calendar.SECOND)<=54){
			miniSecondInFive= "50";
		}if(55<=calendar.get(Calendar.SECOND)){
			miniSecondInFive= "55";
		}
		int minute=calendar.get(Calendar.MINUTE)-1;
		if(0<=minute&&minute<10){
			minuteString="0"+minute;
		}else{
			minuteString=minute+"";
		}
		return minuteString+":"+miniSecondInFive;
	}

	/**
	 * 返回一个时间的周的整数，是这个月的第几周
	 *
	 * @param d
	 *            日期对象
	 * @return 周
	 */
	public static int getWeekOfMonth(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象！");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 返回一个时间的周的整数，是这个年份的第几周
	 *
	 * @param d
	 *            日期对象
	 * @return 周
	 */
	public static int getWeekOfYear(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象！");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
}

