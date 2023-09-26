package com.lama_b4_g1.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lama_b4_g1.backend.models.NewLoanInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.models.EmployeeLoginCredentials;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.repository.EmployeeCardDetailsRepository;
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
	
	@Autowired 
	EmployeeCardDetailsRepository empCardDetailsRepository;

	@PostMapping("/addEmployeeMaster")
	public EmployeeMaster addEmpMaster(@RequestBody EmployeeMaster empMaster) {
		System.out.println(empMaster.getPassword());
        return empMasterService.saveEmpMaster(empMaster);
	}
	
	@PostMapping("/validateLogin")
	public List<String> loginEmployee(@RequestBody EmployeeLoginCredentials empLoginCred) {
		
		List<String> result = new ArrayList<String>();
		if(empLoginCred==null) {
			System.out.println("emp login cred is null!");
			result.add("Null Credentials");
			return result;
//			return new ResponseEntity<>("Null Credientials", HttpStatus.OK);
		}
		result = empMasterService.authenticateEmployee(empLoginCred);
		System.out.println("Employee controller info:");
		System.out.println("Username:"+empLoginCred.getUserName());
		System.out.println("Password:"+empLoginCred.getPassword());
		System.out.println("\nResult:"+result);
		return result;
//		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	@PostMapping("/getLoanList")
	public List<Map<String,String>> getLoanList(@RequestBody Map<String, String> userID){
		
//		System.out.println("UserId to search "+ userID +" ");
//		System.out.println(userID.get("searchId"));
		List<Map<String, String>> loanCardList = empCardDetailsRepository.getLoanListById(userID.get("searchId"));
		System.out.println(loanCardList);
		return loanCardList;
	}
	
	@GetMapping("/viewEmpRecords")
	public List<EmployeeMaster> viewEmpRecords() {
        return empMasterService.viewEmployees();
	}
	
	@PutMapping("/editEmpRecord/{id}")
	public String editEmpRecord(@PathVariable("id") String id, @RequestBody EmployeeMaster em) {
		return empMasterService.editRecord(id, em);
	}
	
	@GetMapping("/findEmp/{id}")
	public EmployeeMaster findEmpById(@PathVariable("id") String id) {
		return empMasterService.findEmpById(id);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmpById(@PathVariable("id") String id) {
		return empMasterService.deleteEmpById(id);
	}

	@PostMapping("/addNewLoan")
	public String addNewLoanData(@RequestBody NewLoanInfo newLoanInfo) {
		return empMasterService.addNewLoanData(newLoanInfo);
	}
}
