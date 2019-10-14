package com.gaoyuan.demo;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.gaoyuan.demo.bean.Goods;
import com.tzh.utils.DecimalCalculate;
import com.tzh.utils.IOToFileUtils;
import com.tzh.utils.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GaoyuanSenior2Week2ApplicationTests {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testList() {
		List<String> readFileByLinesList = IOToFileUtils.readFileByLinesList(System.getProperty("user.dir")+"/src/test/java/test.txt");
		BoundListOperations<String, Object> boundListOps = redisTemplate.boundListOps("goodsList");
		
		for (String string : readFileByLinesList) {
			//定义字符串切割后的数组
			String[] split = string.split("\\==");
			//实例化goods
			Goods goods = new Goods();
			//ID值要使用isNumber()工具方法判断是不是数字
			if(!StringUtils.isNumber(split[0])) {
				//将切割后的第一个赋值给id
				goods.setGid(Integer.parseInt(split[0]));
			}
			//商品名称要使用hasText()方法判断有没有值
			if(StringUtils.hasText(split[1])) {
				goods.setGname(split[1]);
			}
			//价格要使用hasText()方法判断有没有值，并使用isNumber()判断是不是数字
			if(StringUtils.hasText(split[2])) {
				if(StringUtils.isNumber(split[2])) {
					goods.setPrice(BigDecimal.valueOf(split[2]));
				}
			}
			//百分比使用hasText()方法判断有没有值，如果没值则默认为0，并使用isNumber()判断是不是数字,再转成数字
			if(StringUtils.hasText(split[3])) {
				if(StringUtils.isNumber(split[3])) {
					//去掉“%”符号
					split[3].replace("&", "");
					goods.setSaleBfb(Double.parseDouble(split[3]));
				}
			}else {
				goods.setSaleBfb(0);
			}
			
			
			Long leftPush = boundListOps.leftPush(goods);
			System.out.println(leftPush);
		}
	}
	
	@Test
	public void testZset() {
		List<String> readFileByLinesList = IOToFileUtils.readFileByLinesList(System.getProperty("user.dir")+"/src/test/java/test.txt");
		BoundZSetOperations<String, Object> boundZSetOps = redisTemplate.boundZSetOps("goodsZset");
		
		for (String string : readFileByLinesList) {
			//定义字符串切割后的数组
			String[] split = string.split("\\==");
			//实例化goods
			Goods goods = new Goods();
			//ID值要使用isNumber()工具方法判断是不是数字
			if(!StringUtils.isNumber(split[0])) {
				//将切割后的第一个赋值给id
				goods.setGid(Integer.parseInt(split[0]));
			}
			//商品名称要使用hasText()方法判断有没有值
			if(StringUtils.hasText(split[1])) {
				goods.setGname(split[1]);
			}
			//价格要使用hasText()方法判断有没有值，并使用isNumber()判断是不是数字
			if(StringUtils.hasText(split[2])) {
				if(StringUtils.isNumber(split[2])) {
					goods.setPrice(BigDecimal.valueOf(split[2]));
				}
			}
			//百分比使用hasText()方法判断有没有值，如果没值则默认为0，并使用isNumber()判断是不是数字,再转成数字
			if(StringUtils.hasText(split[3])) {
				if(StringUtils.isNumber(split[3])) {
					//去掉“%”符号
					split[3].replace("&", "");
					goods.setSaleBfb(Double.parseDouble(split[3]));
				}
			}else {
				goods.setSaleBfb(0);
			}
			
			
			Boolean add = boundZSetOps.add(goods,goods.getSaleBfb());
			System.out.println(add);
		}
	}

}
