package com.lama_b4_g1.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.models.EmployeeLoginCredentials;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.services.EmployeeMasterService;

@RestController
public class EmployeeMasterController {

	@Autowired
	EmployeeMasterService empMasterService;
	
	@PostMapping("/addEmployeeMaster")
	public EmployeeMaster addEmpMaster(@RequestBody EmployeeMaster empMaster) {
		EmployeeMaster obj = empMasterService.saveEmpMaster(empMaster);
		return obj;
	}
	
	@PostMapping("/validateLogin")
	public String loginEmployee(@RequestBody EmployeeLoginCredentials empLoginCred) {
		if(empLoginCred==null) {
			System.out.println("emp login cred is null!");
			return "Null Credientials";
		}
		String result = empMasterService.authenticateEmployee(empLoginCred);
		System.out.println("Employee controller info:");
		System.out.println("Username:"+empLoginCred.getUserName());
		System.out.println("Password:"+empLoginCred.getPassword());
		System.out.println("\nResult:"+result);
		return result;
		
	}
}
