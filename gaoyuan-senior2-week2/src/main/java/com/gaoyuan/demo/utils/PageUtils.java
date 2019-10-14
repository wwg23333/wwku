package com.gaoyuan.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class PageUtils {
	public static Map<String, Long> pageUtils(long size,long cpage){
		Map<String, Long> map = new HashMap<>();
		
		int pageSize=10;
		long page = size%pageSize>0?1:0;
		long pages = page+size/pageSize;
		
		cpage = cpage<1?1:cpage;
		cpage = cpage >pages?pages:cpage;
		
		long start = (cpage-1)*pageSize;
		long end = start+pageSize-1;
		map.put("cpage", cpage);
		map.put("pages", pages);
		map.put("start", start);
		map.put("end", end);
		
		return map;
		
	}
}
