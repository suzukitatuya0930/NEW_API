package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.PassForgetModel;

@Mapper
public interface PassForgetMapper {

	PassForgetModel selectEmail(PassForgetModel passForgetModel);
	
}
