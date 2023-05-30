package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserListMapper;
import com.example.demo.model.UserListModel;
import com.example.demo.service.UserListService;

import jakarta.annotation.Resource;

@Service
public class UserListServiceImpl implements UserListService {
	@Resource
	UserListMapper mapper;
	@Override
	 public List<UserListModel>userList(UserListModel userListModel) {
	       
	        return mapper.userList(userListModel);
	    }
	@Override
	public List<UserListModel> homePage(UserListModel userListModel) {
		return mapper.homePage(userListModel);
	}

}
