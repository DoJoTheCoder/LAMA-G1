package com.lama_b4_g1.backend.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lama_b4_g1.backend.models.EmployeeIssueDetails;
import com.lama_b4_g1.backend.models.EmployeeItemView;

public interface EmployeeIssueDetailsRepository extends JpaRepository<EmployeeIssueDetails, String>{
	@Query("SELECT new com.lama_b4_g1.backend.models.EmployeeItemView(i.issueId, m.itemDescription, m.itemMake, m.itemCategory, m.itemValuation) "
			+ "FROM EmployeeIssueDetails i INNER JOIN i.itemMaster m"
			+ " WHERE i.empMaster.employeeId=?1")
	public Set<EmployeeItemView> getEmployeeItems(String employeeId);
	
//	public EmployeeIssueDetails findByEmployeeId(String employeeId);
}
