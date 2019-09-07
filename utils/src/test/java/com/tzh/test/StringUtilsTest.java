package com.tzh.test;

import java.util.Random;

import org.junit.Test;

import com.tzh.utils.StringUtils;

public class StringUtilsTest {
	
	@Test
	public void testIsNull() {
		//boolean null1 = StringUtils.isNull(" ");
		boolean null1 = StringUtils.isBlank(" ");
		System.out.println(null1);
	}
	@Test
	public void testPhone() {
		boolean phone = StringUtils.isPhone(null);
		System.out.println(phone);
	}
	@Test
	public void testEmail() {
		boolean email = StringUtils.isEmail("8963@qq.com");
		System.out.println(email);
	}
	@Test
	public void testEnglish() {
		boolean email = StringUtils.isEnglish("dkjdfkjkd");
		System.out.println(email);
	}
	@Test
	public void testPart() {
		//String email = StringUtils.getPartString1("012345");
		String email = StringUtils.getPartString("http://news.cnstock.com/news,yw-201908-4412690.htm");
		//System.out.println(email);
	}
	
	@Test
	public void testRandom() {
		/*Random random = new Random();
		int nextInt = random.nextInt(26);*/
		//String randomStr = StringUtils.getRandomStrAndNumber(5);
		String randomStr = StringUtils.getRandomChinese(3);
		System.out.println(randomStr);
	}

}
