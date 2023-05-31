package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.LoginService;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class LoginController {
	
	
	@Resource LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody  LoginModel loginModel,ResponseModel responseModel) {
		String email = loginModel.getEmail();
	    String password = loginModel.getPassword();

			LoginModel user = loginService.login(loginModel);
	        if (user != null && user.getPassword().equals(password)) {
	        	
	        	
	        	LoginModel login = new LoginModel();
	        	login.setCode("200");
	        	login.setEmail(email);
	        	login.setRole(user.getRole());
	        	
	       
	      	
	            return ResponseEntity.status(HttpStatus.OK).body(login);
	        } else {
	        	
	        	
	        	 responseModel.setCode(400);
	        	 responseModel.setStatus("ERROR");
	        	 responseModel.setInformation("メールアドレス又はパスワードが間違っています");

	             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
	        }
	}
}
	    
