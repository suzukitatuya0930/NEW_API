package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PassChangeModel;
import com.example.demo.service.PassChangeService;

import jakarta.annotation.Resource;

@RestController
@CrossOrigin
public class PassChangeController {
	
	@Resource
	private PassChangeService passChangeService;
	
	@PostMapping("/passchange")
    public ResponseEntity<?> changePassword(@RequestBody PassChangeModel passChangeModel) {
		List<PassChangeModel> a = passChangeService.selectuser(passChangeModel);
    	System.out.println(a.size());
    	if(a.size()!=0) {
    		if(passChangeModel.getNewpassword().equals(passChangeModel.getConfirmpassword())) {
    			int rowsUpdated = passChangeService.updateuser(passChangeModel); 
        if (rowsUpdated == 1) {
            return ResponseEntity.ok("パスワード変更完全しました。");
            
        } else {
        	
            return ResponseEntity.status(400).body("パスワード変更が失敗しました。");
        }
    		}else {
    			
    			return ResponseEntity.status(400).body("新しいパスワードと確認用パスワードが同じではありません。");
    		}
    		
        
    	}else {
    		return ResponseEntity.status(400).body("メールとパスワードが一致しません。");
    	}
    	
    }
}
    
