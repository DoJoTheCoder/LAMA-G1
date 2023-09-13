package com.lama_b4_g1.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.EmployeeCardDetails;
import com.lama_b4_g1.backend.repository.EmployeeCardDetailsRepository;

@Service
public class EmployeeCardDetailsService {
	
	@Autowired
	EmployeeCardDetailsRepository empCardDetailsRepo;

	public List<EmployeeCardDetails> getEmpCardDetails() {
		
		return empCardDetailsRepo.findAll();
	}
	
	//public List<EmployeeCardDetails> getEmpCardDetails(){}

}
