package com.lama_b4_g1.backend.serviceImplementation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.exception.ResourceNotFoundException;
import com.lama_b4_g1.backend.models.EmployeeCardDetails;
import com.lama_b4_g1.backend.models.EmployeeIssueDetails;
import com.lama_b4_g1.backend.models.EmployeeLoginCredentials;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.models.ItemMaster;
import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.models.NewLoanInfo;
import com.lama_b4_g1.backend.repository.EmployeeCardDetailsRepository;
import com.lama_b4_g1.backend.repository.EmployeeIssueDetailsRepository;
import com.lama_b4_g1.backend.repository.EmployeeMasterRepository;
import com.lama_b4_g1.backend.repository.ItemMasterRepository;
import com.lama_b4_g1.backend.repository.LoanCardMasterRepository;
import com.lama_b4_g1.backend.services.EmployeeMasterService;

@Service
public class EmployeeMasterServiceImplementation implements EmployeeMasterService{
	
	@Autowired
	EmployeeMasterRepository empMasterRepo;

	@Autowired
	ItemMasterRepository itemMasterRepo;

	@Autowired
	LoanCardMasterRepository loanCardMasterRepo;

	@Autowired
	EmployeeIssueDetailsRepository empIssueDetailsRepo;

	@Autowired
	EmployeeCardDetailsRepository empCardDetailsRepo;
	
	public List<EmployeeMaster> fetchAllEmployees() {
		
		return empMasterRepo.findAll();
		
	}

	public EmployeeMaster saveEmpMaster(EmployeeMaster empMaster) {

		EmployeeMaster obj = null;
		String Id = empMaster.getEmployeeId();
		Optional<EmployeeMaster> emp = empMasterRepo.findById(Id);
		if(emp.isPresent()){
			empMaster.setEmpCardDetails(emp.get().getEmpCardDetails());
			empMaster.setEmpIssueDetails(emp.get().getEmpIssueDetails());
		}
		return empMasterRepo.save(empMaster);
	}
	
	public List<String> authenticateEmployee(EmployeeLoginCredentials empLoginCred) throws ResourceNotFoundException{
		
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
//				result.add("Invalid Credentials");
			}
			
			// Throw exception when null
			throw new ResourceNotFoundException("Invalid Credentials");
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
	
	public String editRecord(String id, EmployeeMaster emp) {
		String res = "";
		EmployeeMaster em = empMasterRepo.findById(id).get();
		em.setEmployeeId(emp.getEmployeeId());
		em.setEmployeeName(emp.getEmployeeName());
		em.setDesignation(emp.getDesignation());
		em.setDepartment(emp.getDepartment());
		em.setGender(emp.getGender());
		em.setUserName(emp.getUserName());
		em.setPassword(emp.getPassword());
		em.setDoj(emp.getDoj());
		em.setDob(emp.getDob());
		empMasterRepo.save(em);
		res = "Employee Updated Successfully";
		return res;
	}
	
	public EmployeeMaster findEmpById(String id) {
		EmployeeMaster l = null;
		Optional<EmployeeMaster> op =  empMasterRepo.findById(id);
		if(op.isPresent()) l = op.get();
		return l;
	}

	public String deleteEmpById(String id) {
		if(empMasterRepo.existsById(id)) {
			empMasterRepo.deleteById(id);
			return !empMasterRepo.existsById(id) ? "Success" : "Failed";
		} else {
			return "Does not exist";
		}
	}
	@Transactional
	public String addNewLoanData(NewLoanInfo newLoanInfo) {
		System.out.println("add loan was called!");

		String empId = newLoanInfo.getEmployeeId();
		String itemDesc = newLoanInfo.getItemDescription();
		Date issueDate  = new Date(System.currentTimeMillis());

		System.out.println("empId: "+empId);
		System.out.println("itemDesc: "+itemDesc);

		EmployeeMaster empMaster = empMasterRepo.findById(empId).get();
		ItemMaster itemMasterDetails = itemMasterRepo.findByItemDescription(itemDesc);
		LoanCardMaster loanCardMasterDetails = loanCardMasterRepo.findByLoanType(itemMasterDetails.getItemCategory());
		int duration = loanCardMasterDetails.getDurationInYears();
		Calendar c = Calendar.getInstance();
		c.setTime(issueDate);
		c.add(Calendar.YEAR, duration);
		Date returnDate= new Date(c.getTimeInMillis());


		//saving in employee card details
		EmployeeCardDetails empCard = new EmployeeCardDetails();

		//TODO: remove these 2 later when issue table column duplicates are removed
//		empCard.setEmployeeId(empId);
//		empCard.setLoanId(loanCardMasterDetails.getLoanId());

		empCard.setEmpMaster(empMaster);
		empCard.setLoanCardMaster(loanCardMasterDetails);
		empCard.setCardIssueDate(issueDate);

		empCardDetailsRepo.save(empCard);


		//saving in employee issue details
		EmployeeIssueDetails empIssue = new EmployeeIssueDetails();

		// making new issue id in format I101, can be done in other ways
		String maxIssueId = empIssueDetailsRepo.findMaxIssueId();
		int idCount;
		if(maxIssueId != null && !maxIssueId.trim().isEmpty()) {
			idCount = Integer.parseInt(maxIssueId.substring(1));
		}
		else {
			idCount = 101;
		}

		idCount++;
		empIssue.setIssueId("I"+idCount);
		empIssue.setEmpMaster(empMaster);
		empIssue.setIssueDate(issueDate);
		empIssue.setItemMaster(itemMasterDetails);
		empIssue.setReturnDate(returnDate);

		empIssueDetailsRepo.save(empIssue);

		return "ok";
	}

}
