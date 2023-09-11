package com.lama_b4_g1.backend.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class employee_master {
	
	@Id
	@Column(length = 6)
	private String employee_id;
	
	@Column(length = 25)
	private String employee_name;
	
	@Column(length = 25)
	private String designation;
	
	@Column(length = 25)
	private String department;
	
	private char gender;
	
	private Date date_of_birth;
	
	private Date date_of_joining;
	
	@OneToMany(mappedBy = "empMaster")
	private Set<employee_card_details> empCardDetails;
	
	@OneToMany(mappedBy = "empMaster")
	private Set<employee_issue_details> empIssueDetails;

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
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

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

}
