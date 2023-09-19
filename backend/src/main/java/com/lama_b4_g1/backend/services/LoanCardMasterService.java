package com.lama_b4_g1.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.repository.LoanCardMasterRepository;

@Service
public class LoanCardMasterService {
	
	@Autowired
	LoanCardMasterRepository loanCardMasterRepo;
	
	public List<LoanCardMaster> getLoanCardDetails(){
		
		return loanCardMasterRepo.findAll();
	}

	public LoanCardMaster addNewLoanCard(LoanCardMaster newLoanCard) {
		LoanCardMaster obj = loanCardMasterRepo.save(newLoanCard);
		return obj;
	}

	public List<LoanCardMaster> getAllLoans() {
		return loanCardMasterRepo.findAll();
	}

}
