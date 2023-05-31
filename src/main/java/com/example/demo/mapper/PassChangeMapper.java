package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PassChangeModel;

@Repository
@Mapper
public interface PassChangeMapper {
	List<PassChangeModel> selectuser(PassChangeModel passChangeModel);
	int updateuser(PassChangeModel passChangeModel);
}
