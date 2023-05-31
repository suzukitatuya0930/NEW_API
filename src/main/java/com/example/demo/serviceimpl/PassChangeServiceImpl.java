package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.PassChangeMapper;
import com.example.demo.model.PassChangeModel;
import com.example.demo.service.PassChangeService;

import jakarta.annotation.Resource;

@Service
public class PassChangeServiceImpl implements PassChangeService {
	
	@Resource
	private PassChangeMapper mapper;

	@Override
	public List<PassChangeModel> selectuser(PassChangeModel passChangeModel) {
		return mapper.selectuser(passChangeModel);
	}

	@Override
	public int updateuser(PassChangeModel passChangeModel) {
		return mapper.updateuser(passChangeModel);
	}
	
	
}
