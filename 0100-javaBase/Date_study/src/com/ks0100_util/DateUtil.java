package com.ks0100_util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 这个工具类可以提供关于时间和字符串的日期格式转换，还提供了年月日的相关方法
 * 如果涉及到跨时区的服务，直接new Date 会产生时间问题
 * 
 */
public class DateUtil {

	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	private static DateFormat dateFormatmonth = new SimpleDateFormat("yyyy-MM");
	private static DateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected final static TimeZone CHINESE_TIMEZONE = TimeZone.getTimeZone("GMT+8");

	public static Date getChineseTime() {
		return Calendar.getInstance(CHINESE_TIMEZONE).getTime();
	}

	/**
	 * 将时间转换为字符串，格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String convertToTimestamp(Date date) {
		return timestampFormat.format(date);
	}

	/**
	 * 将时间转换为字符串，格式为：HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String convertToTime(Date date) {
		return timeFormat.format(date);
	}

	/**
	 * 将时间转换为字符串，格式为：yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String convertToDate(Date date) {
		return dateFormat.format(date);
	}

	public static Date parseToDate(String date) {
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String parse(String formatText, Date date) {
		DateFormat format = new SimpleDateFormat(formatText);
		return format.format(date);
	}

	public static String convertToDateMonth(Date date) {
		return dateFormatmonth.format(date);
	}

	public static int getYear(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.YEAR);
	}

	public static int getMonth(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Date getDayBefore(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		return c.getTime();
	}

	/**
	 * 获得指定日期的后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayAfter(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		return c.getTime();
	}

	/**
	 * 获取当月最后时间（精确到秒）
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastTimeOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime();
	}

	/**
	 * 提取日期所在月的最后一天
	 * 
	 * @param day
	 * @return
	 */
	public static Date getLastMonthDate(Date date) {

		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		return lastDate.getTime();
	}
}
