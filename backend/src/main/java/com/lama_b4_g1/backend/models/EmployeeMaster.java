package com.lama_b4_g1.backend.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EmployeeMaster {
	@Id
	@Column(length = 6, name = "employee_id")
	private String employeeId;
	
	@Column(length = 25, name = "employee_name")
	private String employeeName;
	
	@Column(length = 25)
	private String designation;
	
	@Column(length = 25)
	private String department;
	
	private char gender;
	
	@Column(name = "date_of_birth")
	private Date dob;
	
	@Column(name = "date_of_joining")
	private Date doj;
	
	@OneToMany(mappedBy = "empMaster")
	private Set<EmployeeCardDetails> empCardDetails;
	
	@OneToMany(mappedBy = "empMaster")
	private Set<EmployeeIssueDetails> empIssueDetails;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Set<EmployeeCardDetails> getEmpCardDetails() {
		return empCardDetails;
	}

	public void setEmpCardDetails(Set<EmployeeCardDetails> empCardDetails) {
		this.empCardDetails = empCardDetails;
	}

	public Set<EmployeeIssueDetails> getEmpIssueDetails() {
		return empIssueDetails;
	}

	public void setEmpIssueDetails(Set<EmployeeIssueDetails> empIssueDetails) {
		this.empIssueDetails = empIssueDetails;
	}

}
