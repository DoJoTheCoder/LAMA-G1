package com.lama_b4_g1.backend.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LoanCardMaster {
	
	@Id
	@Column(length = 6, name = "loan_id")
	private int loanId;
	
	@Column(length = 15, name = "loan_type")
	private char loanType;
	
	@Column(name = "duration_in_years")
	private int durationYears;

	@OneToMany(mappedBy = "loanCardMaster")
	private Set<EmployeeCardDetails> empCardDetail;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public char getLoanType() {
		return loanType;
	}

	public void setLoanType(char loanType) {
		this.loanType = loanType;
	}

	public int getDurationYears() {
		return durationYears;
	}

	public void setDurationYears(int durationYears) {
		this.durationYears = durationYears;
	}

	public Set<EmployeeCardDetails> getEmpCardDetail() {
		return empCardDetail;
	}

	public void setEmpCardDetail(Set<EmployeeCardDetails> empCardDetail) {
		this.empCardDetail = empCardDetail;
	}
}
