package com.lama_b4_g1.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
