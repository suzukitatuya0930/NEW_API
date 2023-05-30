package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.UserListModel;

@Mapper
public interface UserListMapper {
	List<UserListModel>userList(UserListModel userListModel);

	List<UserListModel> homePage(UserListModel userListModel);
}
