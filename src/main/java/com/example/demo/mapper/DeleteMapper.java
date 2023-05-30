package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.DeleteModel;

@Mapper
public interface DeleteMapper {
	int delete(DeleteModel deleteModel);
}
