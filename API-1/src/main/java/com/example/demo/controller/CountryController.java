package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CountryModel;
import com.example.demo.service.CountryService;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class CountryController {
	@Resource
	CountryService countryService;
	
	@GetMapping("/country")
	public ResponseEntity<?> Country(@ModelAttribute CountryModel countryModel) {
		List<CountryModel> countryList = countryService.Country(countryModel);
		System.out.println(countryList);
		return ResponseEntity.ok(countryList);
	}
}
		
	

		
	

