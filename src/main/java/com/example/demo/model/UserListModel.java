package com.example.demo.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserListModel {
	 private String visatype;
	 private Date visadate;
	 private String country;
	 
	 private String firstname;
	 private String middlename;
	 private String lastname;
	 private String firstnamekana;
	 private String middlenamekana;
	 private String lastnamekana;
}
