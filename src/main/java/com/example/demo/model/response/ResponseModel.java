package com.example.demo.model.response;

import java.util.List;

import com.example.demo.model.RegisterModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class ResponseModel {
	
	private int Code;
	
	private String Status;
	
	private String Information;
	
	private List<String> errorlist;
	
	private RegisterModel registerdata;
	
	
	
	
}



