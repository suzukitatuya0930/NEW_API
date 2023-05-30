package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import jakarta.annotation.Resource;

@RestController
public class UserController {
	@Resource
	UserService userService;
	@GetMapping("/user/{email}")
	public ResponseEntity<?> selectUserByEmail(UserModel userModel){
		List<UserModel> user = userService.selectUserByEmail(userModel);
		if(user.size()!=0) {
		return ResponseEntity.ok(user);
	}else {
		return ResponseEntity.status(400).body("アカウント存在しません");
	}
	}
	
}
