package com.lama_b4_g1.backend.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeIssueDetails {
	@Id
	@Column(length = 6, name = "issue_id")
	private String issueId;
	
//	@Column(length = 6, name = "employee_id")
//	private String employeeId;
	
//	@Column(length = 6, name = "item_id")
//	private String itemId;
	
	@Column(name = "issue_date")
	private Date issueDate;
	
	@Column(name = "return_date")
	private Date returnDate;
	
	@ManyToOne
	private EmployeeMaster empMaster;
	
	@ManyToOne
	private ItemMaster itemMaster;

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public EmployeeMaster getEmpMaster() {
		return empMaster;
	}

	public void setEmpMaster(EmployeeMaster empMaster) {
		this.empMaster = empMaster;
	}

	public ItemMaster getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}
}
