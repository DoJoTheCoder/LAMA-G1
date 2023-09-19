package com.lama_b4_g1.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.services.LoanCardMasterService;

@CrossOrigin("http://localhost:3000")
@RestController
public class LoanCardMasterController {
	
	@Autowired
	private LoanCardMasterService loanService;
	
	@PostMapping("/saveLoan")
	public String saveLoan(@RequestBody LoanCardMaster loan)
	{
		return loanService.saveLoan(loan);
	}
	
	@GetMapping("/findAllLoans")
	public List<LoanCardMaster> fetchAllLoans()
	{
		return loanService.findloans();
	}
	
	@PutMapping("/editLoan/{id}")
	public String editLoan(@PathVariable("id") String id, @RequestBody LoanCardMaster lcm) {
		return loanService.editLoan(id, lcm);
	}
	
	@GetMapping("/findLoan/{id}")
	public LoanCardMaster findLoanById(@PathVariable("id") String id) {
		return loanService.findLoanById(id);
	}
	
}
