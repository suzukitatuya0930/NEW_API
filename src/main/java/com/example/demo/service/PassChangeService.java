package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PassChangeModel;

public interface PassChangeService {
	
	public List<PassChangeModel> selectuser(PassChangeModel passChangeModel);
	public int updateuser(PassChangeModel passChangeModel);
}
