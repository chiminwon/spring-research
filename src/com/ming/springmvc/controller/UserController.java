package com.ming.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ming.springmvc.pojo.User;
import com.ming.springmvc.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes({ "u", "a" })
public class UserController {

	@Resource
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(params = "method=register")
	public String register(String userName) {
		System.out.println("Call UserController.register()");
		System.out.println("userName = :: " + userName);
		userService.add(userName);
		return "register_succuss";
	}

	@RequestMapping(params = "method=register_2")
	public ModelAndView register_2(User user) {
		System.out.println("Call UserController.register_2()");
		System.out.println(user.getUserName());
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping(params = "method=register_3")
	public String register_3(@RequestParam("userName") String userName, HttpServletRequest request, ModelMap map) {
		System.out.println("Call UserController.register_3()");
		System.out.println("userName = :: " + userName);
		request.getSession().setAttribute("c", "ccc");
		map.put("a", "aaa");
		return "index";
	}

	@RequestMapping(params = "method=register_4")
	public String register_4(@ModelAttribute("a") String a, HttpServletRequest request, ModelMap map) {
		System.out.println("Call UserController.register_4()");
		System.out.println(a);
		return "redirect:http://www.baidu.com";
	}

	@RequestMapping(params = "method=register_5")
	public ModelAndView register_5(String username) {
		System.out.println("Call UserController.register_5()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		User user = new User("Allen");
		User _user = new User("Angel");
		mv.addObject(user);
		mv.addObject("_user", _user);
		return mv;
	}

}
