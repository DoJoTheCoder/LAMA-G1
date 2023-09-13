package com.lama_b4_g1.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.models.EmployeeCardDetails;
import com.lama_b4_g1.backend.models.EmployeeLoginCredentials;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.services.EmployeeCardDetailsService;
import com.lama_b4_g1.backend.services.EmployeeMasterService;
import com.lama_b4_g1.backend.services.LoanCardMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeMasterController {

	@Autowired
	EmployeeMasterService empMasterService;
	
	@Autowired
	EmployeeCardDetailsService empCardDetailsService;
	
	@Autowired
	LoanCardMasterService loanCardMasterService;
	
	@PostMapping("/addEmployeeMaster")
	public EmployeeMaster addEmpMaster(@RequestBody EmployeeMaster empMaster) {
		System.out.println(empMaster.getPassword());
		EmployeeMaster obj = empMasterService.saveEmpMaster(empMaster);
		return obj;
	}
	
	@PostMapping("/validateLogin")
	public String loginEmployee(@RequestBody EmployeeLoginCredentials empLoginCred) {
		if(empLoginCred==null) {
			System.out.println("emp login cred is null!");
			return "Null Credentials";
//			return new ResponseEntity<>("Null Credientials", HttpStatus.OK);
		}
		String result = empMasterService.authenticateEmployee(empLoginCred);
		System.out.println("Employee controller info:");
		System.out.println("Username:"+empLoginCred.getUserName());
		System.out.println("Password:"+empLoginCred.getPassword());
		System.out.println("\nResult:"+result);
		return result;
//		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	@GetMapping("/getLoanList")
	public List<LoanCardMaster> getLoadList(){
		
		List<EmployeeCardDetails> empCardList = empCardDetailsService.getEmpCardDetails();
		List<LoanCardMaster> loanCardList = loanCardMasterService.getLoanCardDetails();
		return loanCardList;
	}
}
