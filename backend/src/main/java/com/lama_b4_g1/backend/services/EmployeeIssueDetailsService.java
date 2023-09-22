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
	
	@Autowired
	EmployeeMasterRepository empMasterRepo;
	
	@Autowired
	EmployeeCardDetailsRepository empCardDetailsRepo;
	
	
	public Set<EmployeeItemView> getEmployeeItems(String empId) {
		return empIssueDetailsRepo.getEmployeeItems(empId);
	}

	@Transactional
	public String addNewLoanData(NewLoanInfo newLoanInfo) {
		System.out.println("add loan was called!");
		
		String empId = newLoanInfo.getEmployeeId();
		String itemDesc = newLoanInfo.getItemDescription();
		Date issueDate  = new Date(System.currentTimeMillis());
		
		System.out.println("empId: "+empId);
		System.out.println("itemDesc: "+itemDesc);
		
		EmployeeMaster empMaster = empMasterRepo.findById(empId).get();
		ItemMaster itemMasterDetails = itemMasterRepo.findByItemDescription(itemDesc);
		LoanCardMaster loanCardMasterDetails = loanCardMasterRepo.findByLoanType(itemMasterDetails.getItemCategory());
		int duration = loanCardMasterDetails.getDurationYears();
		Calendar c = Calendar.getInstance();
		c.setTime(issueDate);
		c.add(Calendar.YEAR, duration);
		Date returnDate= new Date(c.getTimeInMillis());
		
		
		//saving in employee card details
		EmployeeCardDetails empCard = new EmployeeCardDetails();
	
		//TODO: remove these 2 later when issue table column duplicates are removed
		empCard.setEmployeeId(empId);
		empCard.setLoanId(loanCardMasterDetails.getLoanId());
	
		empCard.setEmpMaster(empMaster);
		empCard.setLoanCardMaster(loanCardMasterDetails);
		empCard.setCardIssueDate(issueDate);
	
		empCardDetailsRepo.save(empCard);
		
		
		//saving in employee issue details
		EmployeeIssueDetails empIssue = new EmployeeIssueDetails();
		
		// making new issue id in format I101, can be done in other ways
		String maxIssueId = empIssueDetailsRepo.findMaxIssueId();
		int idCount;
		if(maxIssueId != null && !maxIssueId.trim().isEmpty()) {
			idCount = Integer.parseInt(maxIssueId.substring(1));
		}
		else {
			idCount = 101;
		}
		
		idCount++;
		empIssue.setIssueId("I"+idCount);
		empIssue.setEmpMaster(empMaster);
		empIssue.setIssueDate(issueDate);
		empIssue.setItemMaster(itemMasterDetails);
		empIssue.setReturnDate(returnDate);
		
		empIssueDetailsRepo.save(empIssue);
		
		return "ok";
	}
	
	
}
