package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.DeleteMapper;
import com.example.demo.model.DeleteModel;
import com.example.demo.service.DeleteService;

import jakarta.annotation.Resource;

@Service
public class DeleteServiceImpl implements DeleteService {
	@Resource
	DeleteMapper mapper;
	@Override
	 public int delete(DeleteModel deleteModel) {
	       
	        return mapper.delete(deleteModel);
	    }

}
