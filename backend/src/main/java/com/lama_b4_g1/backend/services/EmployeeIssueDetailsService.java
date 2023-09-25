package com.lama_b4_g1.backend.services;

import java.sql.Date;
import java.util.Calendar;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.EmployeeCardDetails;
import com.lama_b4_g1.backend.models.EmployeeIssueDetails;
import com.lama_b4_g1.backend.models.EmployeeItemView;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.models.ItemMaster;
import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.models.NewLoanInfo;
import com.lama_b4_g1.backend.repository.EmployeeCardDetailsRepository;
import com.lama_b4_g1.backend.repository.EmployeeIssueDetailsRepository;
import com.lama_b4_g1.backend.repository.EmployeeMasterRepository;
import com.lama_b4_g1.backend.repository.ItemMasterRepository;
import com.lama_b4_g1.backend.repository.LoanCardMasterRepository;

@Service
public class EmployeeIssueDetailsService {
	
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
