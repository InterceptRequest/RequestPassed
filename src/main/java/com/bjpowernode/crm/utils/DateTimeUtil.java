package com.bjpowernode.crm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	public static final SimpleDateFormat SDF19 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat SDF10 = new SimpleDateFormat("yyyy-MM-dd");

	public static String getSysTime(){
		Date date = new Date();
		String dateStr = SDF19.format(date);
		
		return dateStr;
		
	}
}
