package com.lama_b4_g1.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.dto.EmployeeMasterDto;
import com.lama_b4_g1.backend.dto.LoanCardMasterDto;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.services.LoanCardMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoanCardMasterController {
	
	@Autowired
	LoanCardMasterService loanCardMasterService;
	

	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/addLoanCardMaster")
	public LoanCardMasterDto addNewLoanCard(@RequestBody LoanCardMasterDto newLoanCard) {
		LoanCardMaster l = modelMapper.map(newLoanCard, LoanCardMaster.class);
		LoanCardMaster em= loanCardMasterService.addNewLoanCard(l);
		LoanCardMasterDto ld=modelMapper.map(em, LoanCardMasterDto.class);
		return ld;
		
		//return loanCardMasterService.addNewLoanCard(newLoanCard);
	}
	
	
	
	@GetMapping("/getLoanMasterList")
	public List<LoanCardMasterDto> getAllLoanCards(){
		List<LoanCardMaster> l = loanCardMasterService.getAllLoans();		
		List<LoanCardMasterDto> ld = l.stream().map(i->modelMapper.map(i, LoanCardMasterDto.class)).collect(Collectors.toList());
		//return loanCardMasterService.getAllLoans();
		return ld;
	}
	
	@PostMapping("/saveLoan")
	public String saveLoan(@RequestBody LoanCardMasterDto loan)
	{
		LoanCardMaster lcm1 = modelMapper.map(loan, LoanCardMaster.class);
		return loanCardMasterService.saveLoan(lcm1);
	}
	
	
	
	@PutMapping("/editLoan/{id}")
	public String editLoan(@PathVariable("id") String id, @RequestBody LoanCardMasterDto lcm) {
		LoanCardMaster lcm2= modelMapper.map(lcm, LoanCardMaster.class);
		return loanCardMasterService.editLoan(id, lcm2);
	}
	
	@GetMapping("/findLoan/{id}")
	public LoanCardMasterDto findLoanById(@PathVariable("id") String id) {
		LoanCardMaster lf = loanCardMasterService.findLoanById(id);
		return modelMapper.map(lf, LoanCardMasterDto.class);
//		return loanCardMasterService.findLoanById(id);
	}
	
	@DeleteMapping("/deleteLoanCard/{id}")
	public String deleteById(@PathVariable("id") String id) {
		
		return loanCardMasterService.deleteLoanById(id);

	}
}
