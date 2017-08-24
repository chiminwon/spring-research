package com.ming.springmvc.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ming.springmvc.pojo.User;

@Component
public class UserDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void add(User user) {
		System.out.println("Call UserDao.add()");
		hibernateTemplate.save(user);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
