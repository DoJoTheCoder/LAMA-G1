package com.lama_b4_g1.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.repository.LoanCardMasterRepository;

@Service
public class LoanCardMasterService {
	
	@Autowired
	LoanCardMasterRepository loanCardMasterRepo;
	
	public List<LoanCardMaster> findloans(){
		
		return loanCardMasterRepo.findAll();
	}
	
	public List<LoanCardMaster> getLoanCardDetails(){
		
		return loanCardMasterRepo.findAll();
	}
	
	public String saveLoan(LoanCardMaster loan)
	{
		String result="";
		Optional <LoanCardMaster> opt = loanCardMasterRepo.findById(loan.getLoanId());
		if(opt.isPresent())
		{
			result="LoanId already exists";
		}
		else
		{
			LoanCardMaster loanDaata= loanCardMasterRepo.save(loan);
			result="Loan added Successfully";
		}
		return result;
	}
	
	public String editLoan(String id, LoanCardMaster loan) {
		String res = "";
		LoanCardMaster l = loanCardMasterRepo.findById(id).get();
		l.setDurationYears(loan.getDurationYears());
		l.setLoanType(loan.getLoanType());
		loanCardMasterRepo.save(l);
		res = "Loan Updated Successfully";
		return res;
	}

}
