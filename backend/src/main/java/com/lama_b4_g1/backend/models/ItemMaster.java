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
public class ItemMaster {

	@Id	
	@Column(length = 6, name = "item_id")
	private String itemId;
	
	@Column(length = 25, name = "item_description")
	private String itemDescription;
	
	@Column(name = "issue_status")
	private char issueStatus;
	
	@Column(length = 25, name = "item_make")
	private String itemMake;
	
	@Column(length = 20, name = "item_category")
	private String itemCategory;
	
	@Column(length = 6, name = "item_valuation")
	private int itemValuation;
	
	@OneToMany(mappedBy = "itemMaster", orphanRemoval=true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonManagedReference(value = "itemAndEmpIssue")
	private Set<EmployeeIssueDetails> empIssueDetails;

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

	public Set<EmployeeIssueDetails> getEmpIssueDetails() {
		return empIssueDetails;
	}

	public void setEmpIssueDetails(Set<EmployeeIssueDetails> empIssueDetails) {
		this.empIssueDetails = empIssueDetails;
	}
}
