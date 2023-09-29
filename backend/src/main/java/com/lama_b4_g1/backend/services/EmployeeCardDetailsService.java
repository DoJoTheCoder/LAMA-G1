package com.lama_b4_g1.backend.services;

import java.util.List;
import java.util.Map;

import com.lama_b4_g1.backend.models.EmployeeCardDetails;


public interface EmployeeCardDetailsService {


	public List<EmployeeCardDetails> getEmpCardDetails();

	public List<Map<String, String>> getLoanListById(String UserId);
	
	//public List<EmployeeCardDetails> getEmpCardDetails(){}

}
