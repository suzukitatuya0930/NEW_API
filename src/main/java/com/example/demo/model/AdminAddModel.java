package com.example.demo.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AdminAddModel {
	@NotEmpty
	 private String email;
	 private String firstname;
	 private String middlename;
	 private String lastname;
	 private String role;
	 private String password;
	 
}

