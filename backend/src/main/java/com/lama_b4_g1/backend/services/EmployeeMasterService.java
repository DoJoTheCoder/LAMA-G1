package com.lama_b4_g1.backend.services;


import java.util.List;
import com.lama_b4_g1.backend.models.*;

public interface EmployeeMasterService {
	
	
	public List<EmployeeMaster> fetchAllEmployees();

	public EmployeeMaster saveEmpMaster(EmployeeMaster empMaster);
	
	public List<String> authenticateEmployee(EmployeeLoginCredentials empLoginCred);
	
	public List<EmployeeMaster> viewEmployees();
	
	public String editRecord(String id, EmployeeMaster emp); 
	
	public EmployeeMaster findEmpById(String id);
	
	public String deleteEmpById(String id);
	
	public String addNewLoanData(NewLoanInfo newLoanInfo);
}
