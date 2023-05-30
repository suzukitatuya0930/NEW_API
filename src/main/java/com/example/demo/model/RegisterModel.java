package com.example.demo.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RegisterModel {
	@NotEmpty
	 private String email;
	 private String password;
	 private String firstname;
	 private String middlename;
	 private String lastname;
	 private String firstnamekana;
	 private String middlenamekana;
	 private String lastnamekana;
	 private String firstnamekanzi;
	 private String lastnamekanzi;
	 private String visatype;
	 private Date visadate;
	 private String country;
	 

}