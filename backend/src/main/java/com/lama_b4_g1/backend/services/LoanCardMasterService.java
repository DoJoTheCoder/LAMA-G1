package com.lama_b4_g1.backend.services;

import java.util.List;
import com.lama_b4_g1.backend.models.LoanCardMaster;


public interface LoanCardMasterService {
	

	public List<LoanCardMaster> getAllLoans();
	
	public String saveLoan(LoanCardMaster loan);
	
	public String editLoan(String id, LoanCardMaster loan);

	public LoanCardMaster addNewLoanCard(LoanCardMaster newLoanCard);

	public LoanCardMaster findLoanById(String id);

	public String deleteLoanById(String id);
}
