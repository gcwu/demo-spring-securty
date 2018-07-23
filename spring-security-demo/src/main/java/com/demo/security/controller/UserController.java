package com.demo.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.security.entity.User;

@RestController
@RequestMapping("")
public class UserController {
	@GetMapping("/user")
	public List<User> query (){
		List<User> userList = new ArrayList<>();
		User u  = new User();
		u.setPassword("123");
		u.setUserName("张三");
		//userList.add(u);
		return userList;
	}
}
