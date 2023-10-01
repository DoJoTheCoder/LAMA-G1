package com.lama_b4_g1.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lama_b4_g1.backend.models.EmployeeMaster;

public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster, String> {
	EmployeeMaster findByUserName(String userName);
//	EmployeeMaster findByEmployeeId(String empId);
}
