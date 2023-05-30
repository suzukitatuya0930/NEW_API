package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserListModel;
import com.example.demo.service.UserListService;

import jakarta.annotation.Resource;

@RestController
public class UserListController {
	@Resource
	UserListService userListService;
	//ホームページの表示させるデータ
	@GetMapping("/homePage")
	public ResponseEntity<?> homePage(UserListModel userListModel){
		List<UserListModel> homePage = userListService.homePage(userListModel);
		if(homePage.size()!=0) {
		return ResponseEntity.ok(homePage);
	}else {
		return ResponseEntity.status(400).body("ERROR");
	}
	}
	
	//ユーザ一覧
	@GetMapping("/userList")
	public ResponseEntity<?> userList(UserListModel userListModel){
		List<UserListModel> userList = userListService.userList(userListModel);
		if(userList.size()!=0) {
		return ResponseEntity.ok(userList);
	}else {
		return ResponseEntity.status(400).body("ERROR");
	}
	}
	
}
