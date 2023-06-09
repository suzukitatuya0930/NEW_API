package com.example.demo.serviceimpl;

import java.util.DuplicateFormatFlagsException;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.RegisterMapper;
import com.example.demo.model.RegisterModel;
import com.example.demo.service.RegisterService;

import jakarta.annotation.Resource;

@Service
public class RegisterServiceImpl implements RegisterService{
	@Resource
	RegisterMapper mapper;
	
	 @Override
	    public int register(RegisterModel registerModel) {
	        // メールアドレスの重複チェック
	        boolean emailExists = mapper.checkEmailExists(registerModel.getEmail());
	        if (emailExists) {
	            throw new DuplicateFormatFlagsException("既に登録されたメールアドレスです");
	        }

	        // ユーザーの登録
	        return mapper.register(registerModel);
	    }
	}
