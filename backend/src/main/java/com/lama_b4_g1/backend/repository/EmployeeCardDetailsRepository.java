package com.lama_b4_g1.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lama_b4_g1.backend.models.EmployeeCardDetails;

public interface EmployeeCardDetailsRepository extends JpaRepository<EmployeeCardDetails, String>{
	
	EmployeeCardDetails findByEmployeeId(String employeeId);
}
