package com.cloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service")
@RequestMapping("/user")
public interface UserClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/get")
	String getUser();
}
