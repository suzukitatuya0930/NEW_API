package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.PassForgetMapper;
import com.example.demo.model.PassForgetModel;
import com.example.demo.service.PassForgetService;

import jakarta.annotation.Resource;

@Service
public class PassForgetServiceImpl implements PassForgetService {
	@Resource
	PassForgetMapper mapper;

	@Override
	public PassForgetModel selectEmail(PassForgetModel passForgetModel) {
		
		return mapper.selectEmail(passForgetModel);
	}
	
}
