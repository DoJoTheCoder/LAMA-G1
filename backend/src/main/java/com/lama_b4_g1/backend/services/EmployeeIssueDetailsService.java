package com.lama_b4_g1.backend.services;

import java.util.Set;


import com.lama_b4_g1.backend.models.EmployeeItemView;

public interface EmployeeIssueDetailsService {
	
	public Set<EmployeeItemView> getEmployeeItems(String empId);
	
	
}
