package com.lama_b4_g1.backend.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.repository.LoanCardMasterRepository;
import com.lama_b4_g1.backend.services.LoanCardMasterService;

@Service
public class LoanCardMasterServiceImplementation implements LoanCardMasterService{
	
	@Autowired
	LoanCardMasterRepository loanCardMasterRepo;
	
	public List<LoanCardMaster> getAllLoans() {
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
			loanCardMasterRepo.save(loan);
			result="Loan added Successfully";
		}
		return result;
	}
	
	public String editLoan(String id, LoanCardMaster loan) {
		String res = "";
		LoanCardMaster l = loanCardMasterRepo.findById(id).get();
		l.setDurationInYears(loan.getDurationInYears());
		l.setLoanType(loan.getLoanType());
		loanCardMasterRepo.save(l);
		res = "Loan Updated Successfully";
		return res;
	}

	public LoanCardMaster addNewLoanCard(LoanCardMaster newLoanCard) {
		LoanCardMaster obj = null;
		String id  = newLoanCard.getLoanId();
		Optional<LoanCardMaster> lcm = loanCardMasterRepo.findById(id);
		if(lcm.isPresent()) {
			newLoanCard.setEmpCardDetail(lcm.get().getEmpCardDetail());
		}
		return loanCardMasterRepo.save(newLoanCard);
	}

	

	public LoanCardMaster findLoanById(String id) {
		LoanCardMaster l = null;
		Optional<LoanCardMaster> op =  loanCardMasterRepo.findById(id);
		if(op.isPresent()) l = op.get();
		return l;
	}

	public String deleteLoanById(String id) {
		// TODO Auto-generated method stub
		loanCardMasterRepo.deleteById(id);
		return "Sucessfully deleted loan by ID : "+id;
		
	}

}
