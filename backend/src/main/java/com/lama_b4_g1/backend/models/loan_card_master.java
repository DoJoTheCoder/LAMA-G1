package com.lama_b4_g1.backend.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class loan_card_master {
	
	@Id
	@Column(length = 6)
	private int loan_id;
	
	@Column(length = 15)
	private char loan_type;
	
	private int duration_in_years;

	@OneToMany(mappedBy = "loanCardMaster")
	private Set<employee_card_details> empCardDetail;
	
	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public char getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(char loan_type) {
		this.loan_type = loan_type;
	}

	public int getDuration_in_years() {
		return duration_in_years;
	}

	public void setDuration_in_years(int duration_in_years) {
		this.duration_in_years = duration_in_years;
	}
}
