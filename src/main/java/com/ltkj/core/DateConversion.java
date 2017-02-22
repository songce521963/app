package com.ltkj.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {

	public static final String YYYY_MM_DD_HH_MM_SSS = "yyyy-MM-dd hh:mm:ss";
	public static final String YYYYMM = "yyyyMM";
	public static final String YYYY_MM = "yyyy-MM";

	/**
	 * date类型转换成String类型
	 * 
	 * @param date
	 *            要转换的date数据
	 * @param dateFormat
	 *            转换的样式 例如：yyyy-MM-dd hh:mm:sss
	 * @return 转换后的date
	 */
	public static String datatimeToString(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String str = sdf.format(date);
		return str;
	}

	/**
	 * String类型转换成date类型
	 * 
	 * @param date
	 *            要转换的date数据
	 * @param dateFormat
	 *            转换的样式 例如：yyyy-MM-dd hh:mm:sss
	 * @return 转换后的date
	 */
	public static Date dateStringToDate(String dateString, String dateFormat) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = sdf.parse(dateString);
		return date;
	}

}
