package com.lama_b4_g1.backend.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.EmployeeItemView;
import com.lama_b4_g1.backend.repository.EmployeeIssueDetailsRepository;

@Service
public class EmployeeIssueDetailsService {
	
	@Autowired
	EmployeeIssueDetailsRepository empIssueDetailsRepo;
	
	public Set<EmployeeItemView> getEmployeeItems(String empId) {
		return empIssueDetailsRepo.getEmployeeItems(empId);
	}
}
