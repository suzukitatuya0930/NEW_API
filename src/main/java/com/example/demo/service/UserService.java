package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserService {
	List<UserModel>selectUserByEmail(UserModel userModel);
}
