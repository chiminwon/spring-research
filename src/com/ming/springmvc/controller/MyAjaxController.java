package com.ming.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ming.springmvc.pojo.User;

@Controller
@RequestMapping("myajax.do")
public class MyAjaxController {
	
	@RequestMapping(params="method=test1",method=RequestMethod.GET)
	public @ResponseBody List<User> test1(String userName) throws Exception{ 
		String _userName = new String(userName.getBytes("iso8859-1"),"gbk");
		System.out.println(_userName); 
		System.out.println("Call MyAjaxController.test1()");
		List<User> list = new ArrayList<User>();
		list.add(new User("¸ßä¿","123"));
		list.add(new User("ÂíÊ¿±ø","456"));
		return list;
	}
	
}
