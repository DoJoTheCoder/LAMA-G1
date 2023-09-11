package com.lama_b4_g1.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.repository.EmployeeMasterRepository;

@Service
public class EmployeeMasterService {
	
	@Autowired
	private EmployeeMasterRepository empMasterRepo;

	public EmployeeMaster saveEmpMaster(EmployeeMaster empMaster) {
		EmployeeMaster obj = empMasterRepo.save(empMaster);
		return obj;
	}
}
