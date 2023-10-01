package com.lama_b4_g1.backend.models;

public class EmployeeItemView {

	private String issueId;	
	private String itemDescription;
	private String itemMake;
	private String itemCategory;
	private int itemValuation;
	
	public EmployeeItemView(String issueId, String itemDescription, String itemMake, String itemCategory,
			int itemValuation) {
		super();
		this.issueId = issueId;
		this.itemDescription = itemDescription;
		this.itemMake = itemMake;
		this.itemCategory = itemCategory;
		this.itemValuation = itemValuation;
	}
	
	public String getIssueId() {
		return issueId;
	}
	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
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
		
}
