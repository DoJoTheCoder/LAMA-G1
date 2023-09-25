package com.lama_b4_g1.backend.controller;

import java.util.Set;

import com.lama_b4_g1.backend.services.EmployeeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.models.EmployeeItemView;
import com.lama_b4_g1.backend.models.NewLoanInfo;
import com.lama_b4_g1.backend.services.EmployeeIssueDetailsService;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeIssueDetailsController {
	
	@Autowired
	EmployeeIssueDetailsService empIssueDetailsService;

	@GetMapping("/getEmployeeItems/{empId}")
	public Set<EmployeeItemView> getEmployeePurchasedItems(@PathVariable("empId") String empId ) {
		Set<EmployeeItemView> empItemViewSet = empIssueDetailsService.getEmployeeItems(empId);
//		System.out.println(empItemViewSet);
		return empItemViewSet;
	}

}
