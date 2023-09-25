package com.lama_b4_g1.backend.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class LoanCardMaster {
	
	@Id
	@Column(length = 6)
	private String loanId;
	
	@Column(length = 15)
	private String loanType;
	
	@Column(nullable = false, name="duration_in_years")
	private int durationInYears;

	@OneToMany (mappedBy = "loanCardMaster", orphanRemoval=true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonManagedReference(value = "loanAndEmpCard")
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

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}

	public Set<EmployeeCardDetails> getEmpCardDetail() {
		return empCardDetail;
	}

	public void setEmpCardDetail(Set<EmployeeCardDetails> empCardDetail) {
		this.empCardDetail = empCardDetail;
	}
	
}
