package com.lama_b4_g1.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lama_b4_g1.backend.models.LoanCardMaster;

public interface LoanCardMasterRepository extends JpaRepository<LoanCardMaster, String> {
	
	LoanCardMaster findByLoanId(String loanId);
	
	LoanCardMaster findByLoanType(String loanType);
}
