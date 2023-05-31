package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CountryModel;
@Repository
@Mapper
public interface CountryMapper {
	
	
	List<CountryModel> country(CountryModel countryModel);
}

