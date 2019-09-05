package com.bw.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("list.do")
	public String lit() {
		System.out.println("hahahah");
		//跳转到list页面显示结果
		return "list";
	}
}
