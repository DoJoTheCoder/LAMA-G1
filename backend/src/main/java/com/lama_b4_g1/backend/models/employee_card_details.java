package com.lama_b4_g1.backend.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class employee_card_details {
	
	@Id
	@Column(length = 6)
	private String employee_id;
	
	@Column(length=6)
	private String loan_id;

	private Date card_issue_date;	
	
	@ManyToOne
	//@JoinColumn()
	private loan_card_master loanCardMaster;
	
	@ManyToOne
	private employee_master empMaster;
	
	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}

	public Date getCard_issue_date() {
		return card_issue_date;
	}

	public void setCard_issue_date(Date card_issue_date) {
		this.card_issue_date = card_issue_date;
	}
}
