package com.gaoyuan.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaoyuan.demo.utils.PageUtils;

@Controller
public class GoodsController {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	//list
	@RequestMapping("listL")
	public String list(Model model,@RequestParam(defaultValue="1")int cpage) {
		
		BoundListOperations<String, Object> boundListOps = redisTemplate.boundListOps("goodsList");
		
		Map<String, Long> pageMap = PageUtils.pageUtils(boundListOps.size(), cpage);
		//将商品编号倒序显示
		List<Object> range = boundListOps.range(pageMap.get("start"), pageMap.get("end"));
		
		model.addAttribute("goodsList", range);
		model.addAttribute("cpage", cpage);
		//跳转到页面
		return "list";
		
	}
	
	//Zset
	@RequestMapping("listZ")
	public String listZset(Model model,@RequestParam(defaultValue="1")int cpage) {
		
		BoundZSetOperations<String, Object> boundZSetOps = redisTemplate.boundZSetOps("goodsZset");
		
		Map<String, Long> pageMap = PageUtils.pageUtils(boundZSetOps.size(), cpage);
		//按照百分比排序显示
		Set<Object> range = boundZSetOps.reverseRange(pageMap.get("start"), pageMap.get("end"));
		
		model.addAttribute("goodsList", range);
		model.addAttribute("cpage", cpage);
		//跳转到页面
		return "listZset";
		
	}
	
}
