package com.tzh.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.tzh.utils.DateUtils;

public class TestDateUtils {
	
	@Test
	public void testAge() {
		int age = DateUtils.getAge("1995-10-01");
		System.out.println(age);
	}
	@Test
	public void testDays() {
		int futureDays = DateUtils.getFutureDays("2019-06-05");
		System.out.println(futureDays);
	}
	
	@Test
	public void test() {
		
		/*Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int DAY_OF_WEEK_IN_MONTH = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println(year);
		System.out.println(month);
		System.out.println(DAY_OF_WEEK_IN_MONTH);*/
		
		/*boolean dayInWeek = DateUtils.isDayInWeek("2019-09-03");
		System.out.println(dayInWeek);*/
		DateUtils.setInitDate("2019-09-03");
		
	}
	
	

}
