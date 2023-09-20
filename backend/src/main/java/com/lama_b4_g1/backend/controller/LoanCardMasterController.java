package com.lama_b4_g1.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/saveLoan")
	public String saveLoan(@RequestBody LoanCardMaster loan)
	{
		return loanCardMasterService.saveLoan(loan);
	}
	
	@GetMapping("/findAllLoans")
	public List<LoanCardMaster> fetchAllLoans()
	{
		return loanCardMasterService.findloans();
	}
	
	@PutMapping("/editLoan/{id}")
	public String editLoan(@PathVariable("id") String id, @RequestBody LoanCardMaster lcm) {
		return loanCardMasterService.editLoan(id, lcm);
	}
	
	@GetMapping("/findLoan/{id}")
	public LoanCardMaster findLoanById(@PathVariable("id") String id) {
		return loanCardMasterService.findLoanById(id);
	}
	
	@DeleteMapping("/deleteLoanCard/{id}")
	public String deleteById(@PathVariable("id") String id) {
		
		return loanCardMasterService.deleteLoanById(id);

	}
}
