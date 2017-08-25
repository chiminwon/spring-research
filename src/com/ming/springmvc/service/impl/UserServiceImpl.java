package com.ming.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ming.springmvc.dao.UserDao;
import com.ming.springmvc.pojo.User;
import com.ming.springmvc.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add(String userName) {
		System.out.println("Call UserService.add()");
		User user = new User();
		user.setUserName(userName);
		userDao.add(user);
	}
}
