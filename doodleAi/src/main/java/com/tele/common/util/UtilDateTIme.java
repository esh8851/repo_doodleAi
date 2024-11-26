package com.tele.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.tele.common.constants.Constants;

public class UtilDateTIme {
	
	public static String add00TimeString(String date) {
		return date + " 00:00:00";
	}

	public static String add59TimeString(String date) {
		return date + " 23:59:59";
	}
	
	public static String nowString() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeString = localDateTime.format(DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT_BASIC));
		return localDateTimeString;
	}
	
}
