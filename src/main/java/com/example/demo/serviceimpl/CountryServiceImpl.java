package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.CountryMapper;
import com.example.demo.model.CountryModel;
import com.example.demo.service.CountryService;

import jakarta.annotation.Resource;
@Service
public  class CountryServiceImpl implements CountryService {
	
	 @Resource
	    private CountryMapper countryMapper;

	public List<CountryModel> Country(CountryModel countryModel) {
		
		 return countryMapper.Country(countryModel);
    }
	}


