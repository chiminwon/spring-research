package com.ming.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ming.springboot.pojo.User;
import com.mongodb.WriteResult;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	// 创建线程安全的Map
//	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUserList() {
		// 处理"/users/"的GET请求，用来获取用户列表
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		return mongoTemplate.findAll(User.class);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postUser(@ModelAttribute User user) {
		// 处理"/users/"的POST请求，用来创建User
		// 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
		User user1 = new User();
		user1.setUid(1l);
		user1.setName("Allen");
		user1.setAge(18);
		mongoTemplate.save(user1);
		
		User user2 = new User();
		user2.setUid(2l);
		user2.setName("Angel");
		user2.setAge(18);
		mongoTemplate.save(user2);
		
		User user3 = new User();
		user3.setUid(3l);
		user3.setName("Tony");
		user3.setAge(2);
		mongoTemplate.save(user3);
		
		return "success";
	}

	@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
	public User getUser(@PathVariable String uid) {
		// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
		// url中的id可通过@PathVariable绑定到函数的参数中
		return mongoTemplate.findById(Long.valueOf(uid), User.class);
	}

	@RequestMapping(value = "/{uid}", method = RequestMethod.PUT)
	public WriteResult putUser(@PathVariable Long uid, @ModelAttribute User user) {
		// 处理"/users/{id}"的PUT请求，用来更新User信息
		return mongoTemplate.updateFirst(  
                new Query(Criteria.where("uid").is(uid)),  
                Update.update("name", user.getName()), User.class); 
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable String name) {
		// 处理"/users/{id}"的DELETE请求，用来删除User
		mongoTemplate.remove(new Query(Criteria.where("name").is(name)), User.class);
		return "success";
	}

}
