package com.cp.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateNow {
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private static Date date = new Date();
	public static Date getDate() throws ParseException {
		String d = formatter.format(date);
		return formatter.parse(d);
	}
}
