package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Javautility {
	
	public int getrandomnumber() {
		Random ran=new Random();
		int rannum = ran.nextInt(10000);
		return rannum;
	}
	
	public String getsystemdateYYYYDDMM() {
		Date dateobj= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		return date;		
	}
	
	public String getsystemdateYYYYDDMM(int days) {
		
		Date dateobj=new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateobj);
		Calendar cal= sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate= sim.format(cal.getTime());
		System.out.println(reqdate);
		return reqdate;
}
}
