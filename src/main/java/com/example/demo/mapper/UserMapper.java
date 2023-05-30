package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.UserModel;

@Mapper
public interface UserMapper {
	List<UserModel>selectUserByEmail(UserModel userModel);
}
