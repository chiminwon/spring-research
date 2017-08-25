package com.ming.springmvc.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ming.springmvc.dao.UserDao;
import com.ming.springmvc.pojo.User;

@Component("userDao")
public class UserDaoImpl implements UserDao{
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public void add(User user) {
		System.out.println("Call UserDao.add()");
		hibernateTemplate.save(user);
	}

}
