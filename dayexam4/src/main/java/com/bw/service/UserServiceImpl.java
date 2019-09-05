package com.bw.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.mapper.UserMapperDao;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapperDao userMapperDao;
	
}
