package com.lama_b4_g1.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.services.LoanCardMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoanCardMasterController {
	
	@Autowired
	LoanCardMasterService loanCardMasterService;
	
	@PostMapping("/addLoanCardMaster")
	public LoanCardMaster addNewLoanCard(@RequestBody LoanCardMaster newLoanCard) {
		
		return loanCardMasterService.addNewLoanCard(newLoanCard);
	}
	
	
	@GetMapping("/getLoanMasterList")
	public List<LoanCardMaster> getAllLoanCards(){
		return loanCardMasterService.getAllLoans();
	}

}
