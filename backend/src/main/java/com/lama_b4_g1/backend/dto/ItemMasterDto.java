package com.lama_b4_g1.backend.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.lama_b4_g1.backend.models.EmployeeIssueDetails;

public class ItemMasterDto {
	

	private String itemId;

	private String itemDescription;

	private char issueStatus;

	private String itemMake;
	

	private String itemCategory;
	

	private int itemValuation;
	
//	@OneToMany(mappedBy = "itemMaster")
//	private Set<EmployeeIssueDetails> empIssueDetails;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public char getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(char issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getItemMake() {
		return itemMake;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemValuation() {
		return itemValuation;
	}

	public void setItemValuation(int itemValuation) {
		this.itemValuation = itemValuation;
	}

//	public Set<EmployeeIssueDetails> getEmpIssueDetails() {
//		return empIssueDetails;
//	}
//
//	public void setEmpIssueDetails(Set<EmployeeIssueDetails> empIssueDetails) {
//		this.empIssueDetails = empIssueDetails;
//	}

}
