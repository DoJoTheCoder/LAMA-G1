package com.lama_b4_g1.backend.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class LoanCardMaster {
	
	@Id
	@Column(length = 6)
	private String loanId;
	
	@Column(length = 15)
	private String loanType;
	
	@Column(nullable = false, name="duration_in_years")
	private int durationYears;

	@OneToMany
//	@JsonManagedReference
	private Set<EmployeeCardDetails> empCardDetail;

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
