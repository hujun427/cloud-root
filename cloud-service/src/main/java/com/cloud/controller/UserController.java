package com.cloud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.model.User;
import com.cloud.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<User> getUser(Integer level) {
		logger.info("==========search user by level, value is "+level);
		return userRepository.findByLevel(level);
	}
	
	@RequestMapping(value = "/getByCode", method = RequestMethod.GET)
	public List<User> getUser(String code) {
		return userRepository.findByCodeLike(code);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<User> getAllUser() {
		logger.info("==========search all users");
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Integer level) {
		User user = new User();
		user.setName("张三");
		user.setAge(30);
		user.setLevel(level);
		user.setCode("zhangsan");
		user.setAddress("上海市徐汇区");
		userRepository.save(user);
		return "add success";
	}
}
