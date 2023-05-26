package com.example.demo.controller;

import java.util.DuplicateFormatFlagsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RegisterModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.RegisterService;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class RegisterController {
	
	@Resource RegisterService registerService;
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterModel registerModel) {
		try {
			registerService.register(registerModel);
			return ResponseEntity.status(HttpStatus.OK).body(registerModel);
		} catch (DuplicateFormatFlagsException ex) {
			// メールアドレスが重複している場合の処理
			ResponseModel responseModel = new ResponseModel();
			responseModel.setCode(HttpStatus.BAD_REQUEST.value());
			responseModel.setStatus("ERROR");
			responseModel.setInformation("既に登録されたメールアドレスです");
			responseModel.setRegisterData(registerModel);
			return ResponseEntity.badRequest().body(responseModel);
		} catch (Exception ex) {
			// その他の例外が発生した場合の処理
			log.error("ユーザー登録エラー: ", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}