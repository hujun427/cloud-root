package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.client.UserClient;

@RestController
public class UserController {
	
	@Autowired
	UserClient userClient;
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public String getAllUser() {
		return "hello " + userClient.getUser();
	}
}
