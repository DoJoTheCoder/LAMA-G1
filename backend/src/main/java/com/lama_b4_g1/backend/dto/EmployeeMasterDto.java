package com.lama_b4_g1.backend.dto;

import java.sql.Date;
//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
//
//import javax.persistence.OneToMany;
//
//import com.lama_b4_g1.backend.models.EmployeeCardDetails;
//import com.lama_b4_g1.backend.models.EmployeeIssueDetails;

public class EmployeeMasterDto {
	
	@Id
	@NotBlank(message = "ID cannot be blank")
	private String employeeId;
	@NotBlank(message = "Name cannot be blank")
	private String employeeName;
	@NotBlank(message = "Designation cannot be blank")
	private String designation;
	@NotBlank(message = "Department cannot be blank")
	private String department;
	@NotBlank(message = "Please choose a gender")
	private char gender;
	@NotBlank(message = "Please choose a valid username")
	private String userName;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,12}$",
            message = "password must be min 4 and max 12 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	private String password;
	@NotNull(message = "Plesae choose a suitable date")
	private Date dob;
	
	@NotNull(message = "Please choose a suitable date")
	private Date doj;
	@NotNull(message = "Please choose access type")
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
