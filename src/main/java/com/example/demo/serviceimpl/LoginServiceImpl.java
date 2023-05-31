package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.LoginMapper;
import com.example.demo.model.LoginModel;
import com.example.demo.service.LoginService;

import jakarta.annotation.Resource;
@Service
public class LoginServiceImpl implements LoginService {
	
	 @Resource
	    private LoginMapper loginMapper;

	 @Override
	 //public List<LoginModel> Login(LoginModel loginModel) {
		public LoginModel Login(LoginModel loginModel) {
		 return loginMapper.Login(loginModel);
 }
	}


