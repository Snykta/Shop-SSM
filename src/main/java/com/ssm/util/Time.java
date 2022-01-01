package com.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Time {
	
	/**
	 *获取时间
	 * @return
	 */
	public static String getTimes() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String udata = sf.format(d);
		return udata;
	}
	
	/**
	 * 将时间定义为订单
	 * @return
	 */
	public static int getTimeCode() {
		int romd =  (int) ((Math.random()*(99999999-10000000))+10000000);
		
		return 	romd;
	}
	

}
