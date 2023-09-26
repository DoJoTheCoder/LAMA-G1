package com.lama_b4_g1.backend.dto;

import java.sql.Date;
//import java.util.Set;

import javax.persistence.Column;
//
//import javax.persistence.OneToMany;
//
//import com.lama_b4_g1.backend.models.EmployeeCardDetails;
//import com.lama_b4_g1.backend.models.EmployeeIssueDetails;

public class EmployeeMasterDto {
	
	

	private String employeeId;

	private String employeeName;

	private String designation;

	private String department;
	
	private char gender;

	private String userName;
	
	private String password;
	
	private Date dob;
	

	private Date doj;
	
	private String accessType;
	
//	@OneToMany(mappedBy = "empMaster")
//	private Set<EmployeeCardDetails> empCardDetails;
//	
//	@OneToMany(mappedBy = "empMaster")
//	private Set<EmployeeIssueDetails> empIssueDetails;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}


	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

//	public Set<EmployeeCardDetails> getEmpCardDetails() {
//		return empCardDetails;
//	}
//
//	public void setEmpCardDetails(Set<EmployeeCardDetails> empCardDetails) {
//		this.empCardDetails = empCardDetails;
//	}
//
//	public Set<EmployeeIssueDetails> getEmpIssueDetails() {
//		return empIssueDetails;
//	}
//
//	public void setEmpIssueDetails(Set<EmployeeIssueDetails> empIssueDetails) {
//		this.empIssueDetails = empIssueDetails;
//	}

}
