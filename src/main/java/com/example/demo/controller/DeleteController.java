package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DeleteModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.DeleteService;

import jakarta.annotation.Resource;

@RestController
public class DeleteController {
	@Resource
	DeleteService deleteService;
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<?> delete(DeleteModel deleteModel,ResponseModel responseModel){
		int user = deleteService.delete(deleteModel);
		if(user==1) {
			responseModel.setInformation("削除できました");
			return ResponseEntity.ok(responseModel);
		}else if(user!=1) {
			responseModel.setInformation("削除できませんでした");
			responseModel.setStatus("ERROR");
			return ResponseEntity.status(400).body(responseModel);
		}else {
			responseModel.setInformation("タイムアウトが発生しました");
			responseModel.setStatus("TIMEOUT");
			return ResponseEntity.status(500).body(responseModel);
		}
	
		
	}
	
}
