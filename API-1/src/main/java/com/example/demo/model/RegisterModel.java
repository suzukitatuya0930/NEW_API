package com.example.demo.model;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterModel {
	@NotEmpty
	 private String email;
	 private String password;
	 private String fisrtname;
	 private String middlename;
	 private String lastname;
	 private String fisrtnamekana;
	 private String middlenamekana;
	 private String lastnamekana;
	 private String fisrtnamekanzi;
	 private String lastnamekanzi;
	 private String visatype;
	 private Date visadate;
	 
	 

}
