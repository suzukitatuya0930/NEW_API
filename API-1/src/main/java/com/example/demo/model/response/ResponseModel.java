package com.example.demo.model.response;

import java.util.List;

import com.example.demo.model.RegisterModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class ResponseModel {
	private int Code;
	private String Status;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String Information;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> errorlist;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	
	public void setRegisterData(RegisterModel registerModel) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}



