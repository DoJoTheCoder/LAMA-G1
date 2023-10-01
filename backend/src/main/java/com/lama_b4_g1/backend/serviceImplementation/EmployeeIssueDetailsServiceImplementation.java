package com.lama_b4_g1.backend.serviceImplementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.EmployeeItemView;
import com.lama_b4_g1.backend.repository.EmployeeIssueDetailsRepository;
import com.lama_b4_g1.backend.repository.ItemMasterRepository;
import com.lama_b4_g1.backend.repository.LoanCardMasterRepository;
import com.lama_b4_g1.backend.services.EmployeeIssueDetailsService;


@Service
public class EmployeeIssueDetailsServiceImplementation implements EmployeeIssueDetailsService{
	
	@Autowired
	EmployeeIssueDetailsRepository empIssueDetailsRepo;
	
	@Autowired
	ItemMasterRepository itemMasterRepo;
	
	@Autowired
	LoanCardMasterRepository loanCardMasterRepo;
	
	public Set<EmployeeItemView> getEmployeeItems(String empId) {
		return empIssueDetailsRepo.getEmployeeItems(empId);
	}


}
