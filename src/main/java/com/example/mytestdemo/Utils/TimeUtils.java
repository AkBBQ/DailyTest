package com.example.mytestdemo.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
	private static long  oneDayTimes = (1000 * 60 * 60 * 24) * 1;


	private static String yyyMMDD= "yyyy-MM-dd";
	private static String  yyMMddHHmmss= "yyyy-MM-dd HH:mm:ss";
	private static String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	/**
	 * 判断是否跨天
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public boolean  isMoreOneDay(Date startDate,Date endDate){

		long dayResult =  endDate.getTime() -  startDate.getTime();
		if(dayResult>dayResult) return true;
		return false;
	}




	public static String formatToDateStart(String start) throws ParseException{
		if(null == start){
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate  =  sf.parse(start) ;
		start = sf.format(startDate);
		return start +" 00:00:00";
	}

	public static String formatToDateEnd(String end) throws ParseException{
		if(null == end){
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate  =  sf.parse(end) ;
		end = sf.format(startDate);
		return end +" 23:59:59";
	}

	public int getDays(String start ,String end) throws ParseException{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate= sf.parse(start);
		Date endDate= sf.parse(end);
		long day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
		return new Long(day).intValue()+1;
	}

	// 获取下一天
	public  String getNextDate(String date) throws ParseException{
		SimpleDateFormat sf = new SimpleDateFormat(yyMMddHHmmss);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sf.parse(date));
		int day = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, day+1);
		Date date1 = new Date(calendar.getTimeInMillis());
		return sf.format(date1);
	}

	/**s
	 * 获取当前时间
	 */
	public static String getCurrentTime(Date date) throws ParseException{
		SimpleDateFormat sf = new SimpleDateFormat(yyyyMMddHHmmss);
		return sf.format(date);
	}

	/**
	 * 格式化日期
	 *
	 * @param parse 解析格式 yyyyMMddHHmmssSSS
	 * @return formatDate-parse
	 */
	public static String formatDate(String parse){
		SimpleDateFormat sdf = new SimpleDateFormat(parse);
		return sdf.format(new Date());
	}
	/**
	 * 时间拆分函数
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public String[][] breakUpDays(String start ,String end) throws ParseException{
		int days = getDays(start,end);
		String[][] daySet = new String[days][2];
		String nextDate = start;
		for(int i= 0;i<days;i++){
			daySet[i][0] = formatToDateStart(nextDate);
			daySet[i][1] = formatToDateEnd(nextDate);
			nextDate = getNextDate(nextDate);
		}
		daySet[0][0] = start;
		daySet[days-1][1] = end;
		return daySet;
	}
	/**
	 * 获得输入的起始时间和结束时间在该月里的号数集合。
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public int[] getDayOfMonth(String start ,String end) throws ParseException{
		int days = getDays(start,end);
		//String[] daySet = new String[days];
		int[] daySet = new int[days];
		String nextDate = start;
		for(int i= 0;i<days;i++){
			//daySet[i][0] = formatToDateStart(nextDate);
			daySet[i] =  Integer.parseInt(nextDate.substring(8, 10));
			nextDate = getNextDate(nextDate);
		}
		//daySet[0] = start;
		return daySet;
	}
	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算两个字符串日期之间相差的天数
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 */
	public static int daysBetween(String smdate,String bdate) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 加减秒数
	 * @param date
	 * @param seconds
	 * @return
	 * @throws ParseException
	 */
	public static String addSeconds(Date date, int seconds, String patten){
		//结束时间为当前时间
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, seconds);
		return new SimpleDateFormat(patten).format(calendar.getTime());
	}



	public static void main (String[] args) throws Exception
	{

		String startTime = "2015-01-28 09:20:30";
		String endTime = "2015-03-01 09:20:30";
		TimeUtils time = new TimeUtils();


		int days =  time.getDays(startTime,endTime);
		System.out.println("相隔的天数="+days);
		String[][] daySet =  time.breakUpDays(startTime,endTime);
		for (int j = 0; j < daySet.length; j++) {
			System.out.println("start Date="+daySet[j][0]+";end Date = "+daySet[j][1]);
		}

		Date date = new Date();
		String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

		System.out.println("currTime Date="+currTime);
	}
}
