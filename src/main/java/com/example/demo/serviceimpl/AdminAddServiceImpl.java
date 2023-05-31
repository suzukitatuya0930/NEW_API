package com.example.demo.serviceimpl;

import java.util.DuplicateFormatFlagsException;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.AdminAddMapper;
import com.example.demo.model.AdminAddModel;
import com.example.demo.service.AdminAddService;

import jakarta.annotation.Resource;

@Service
public class AdminAddServiceImpl implements AdminAddService{
	
	@Resource
	AdminAddMapper mapper;
	
	@Override
	public Object adminadd(AdminAddModel adminAddModel) {
		// メールアドレスの重複チェック
        boolean emailExists = mapper.checkEmailExists(adminAddModel.getEmail());
        if (emailExists) {
            throw new DuplicateFormatFlagsException("既に登録されたメールアドレスです");
        }
        // ユーザーの登録
		return mapper.adminadd(adminAddModel);
	}

}
