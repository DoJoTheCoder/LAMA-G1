package com.lama_b4_g1.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.EmployeeLoginCredentials;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.repository.EmployeeMasterRepository;

@Service
public class EmployeeMasterService {
	
	@Autowired
	private EmployeeMasterRepository empMasterRepo;
	
	public List<EmployeeMaster> fetchAllEmployees() {
		
		return empMasterRepo.findAll();
		
	}

	public EmployeeMaster saveEmpMaster(EmployeeMaster empMaster) {
		EmployeeMaster obj = empMasterRepo.save(empMaster);
		return obj;
	}
	
	public List<String> authenticateEmployee(EmployeeLoginCredentials empLoginCred) {
		
		List<String> result = new ArrayList<String>();
		String userName = empLoginCred.getUserName();
		String password = empLoginCred.getPassword();
		EmployeeMaster empMaster = empMasterRepo.findByUserName(userName);
		
		
		System.out.println("Service outputs:");
		if(empMaster==null || !password.equals(empMaster.getPassword())) {
			if(empMaster==null) {
				System.out.println("retrieved record is null");
			}
			else {
				System.out.println("emp cred pass:"+password+", retrieved emp cred:"+empMaster.getPassword()+"..");
				result.add("Invalid Credentials");
			}
			
		}
		else {
			
			System.out.println(empMaster.getAccessType());
			if(empMaster.getAccessType().equals("Admin")) {
				result.add("Admin");
			}
			else {
				result.add("User");
			}
			
			result.add(empMaster.getEmployeeId());
			result.add(empMaster.getEmployeeName());
		}
		
		return result;
	}
	
	public List<EmployeeMaster> viewEmployees() {
		List<EmployeeMaster> list = empMasterRepo.findAll();
		return list;
	}
}
