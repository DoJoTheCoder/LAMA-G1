package com.lama_b4_g1.backend.dto;

//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.OneToMany;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.lama_b4_g1.backend.models.EmployeeCardDetails;

public class LoanCardMasterDto {
	
	
	private String loanId;
	private String loanType;
	private int durationInYears;
	//private Set<EmployeeCardDetails> empCardDetail;

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}

//	public Set<EmployeeCardDetails> getEmpCardDetail() {
//		return empCardDetail;
//	}
//
//	public void setEmpCardDetail(Set<EmployeeCardDetails> empCardDetail) {
//		this.empCardDetail = empCardDetail;
//	}
}
