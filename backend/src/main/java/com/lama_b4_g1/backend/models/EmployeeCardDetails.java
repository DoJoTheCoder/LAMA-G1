package com.lama_b4_g1.backend.models;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class EmployeeCardDetails {
	
//	@Column(length = 6, name="employee_id")
//	private String employeeId;
	
//	@Id
//	@Column(length=6, name="loan_id")
//	private String loanId;

	@Id
	@GeneratedValue
	@Column(name = "emp_card_id")
	private int empCardId;

	@Column(name="card_issue_date")
	private Date cardIssueDate;	
	
	@ManyToOne
	@JsonBackReference(value = "loanAndEmpCard")
	@JoinColumn(name="loan_id")
	private LoanCardMaster loanCardMaster;
	
	@ManyToOne
	@JsonBackReference(value = "masterAndEmpCard")
	@JoinColumn(name = "employee_id")
	private EmployeeMaster empMaster;
	
	
//	public String getEmployeeId() {
//		return employeeId;
//	}
//
//	public void setEmployeeId(String employeeId) {
//		this.employeeId = employeeId;
//	}
//
//	public String getLoanId() {
//		return loanId;
//	}
//
//	public void setLoanId(String loanId) {
//		this.loanId = loanId;
//	}

	public Date getCardIssueDate() {
		return cardIssueDate;
	}

	public int getEmpCardId() {
		return empCardId;
	}

	public void setEmpCardId(int empCardId) {
		this.empCardId = empCardId;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}

	public LoanCardMaster getLoanCardMaster() {
		return loanCardMaster;
	}

	public void setLoanCardMaster(LoanCardMaster loanCardMaster) {
		this.loanCardMaster = loanCardMaster;
	}

	public EmployeeMaster getEmpMaster() {
		return empMaster;
	}

	public void setEmpMaster(EmployeeMaster empMaster) {
		this.empMaster = empMaster;
	}
	
}
