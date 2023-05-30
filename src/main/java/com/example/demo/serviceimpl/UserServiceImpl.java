package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import jakarta.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper mapper;
	@Override
	 public List<UserModel>selectUserByEmail(UserModel userModel) {
	       
	        return mapper.selectUserByEmail(userModel);
	    }

}
