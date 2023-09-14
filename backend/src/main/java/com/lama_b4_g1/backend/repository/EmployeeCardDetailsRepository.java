package com.lama_b4_g1.backend.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lama_b4_g1.backend.models.EmployeeCardDetails;

public interface EmployeeCardDetailsRepository extends JpaRepository<EmployeeCardDetails, String>{
	
	EmployeeCardDetails findByEmployeeId(String employeeId);
	
//	@Query(value = "Select ecard.loanId, lcard.loanType, lcard.durationYears, ecard.cardIssueDate "+
//					" from EmployeeCardDetails ecard inner JOIN ecard.loanCardMaster lcard "+
//					" where ecard.employeeId = ?1", nativeQuery = false)
	@Query(value = "Select ecard.loan_id, lcard.loan_type, lcard.duration_in_years, ecard.card_issue_date \r\n"
			+ "from loandb.employee_card_details as ecard inner JOIN loandb.loan_card_master as lcard\r\n"
			+"on lcard.loan_id = ecard.loan_id\r\n"
			+ "where ecard.employee_id = ?1", nativeQuery = true)
	public List<Map<String, String>> getLoanListById(String empId);
}
