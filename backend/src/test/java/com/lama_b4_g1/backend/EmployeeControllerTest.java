/*package com.lama_b4_g1.backend;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.repository.EmployeeCardDetailsRepository;
import com.lama_b4_g1.backend.repository.EmployeeIssueDetailsRepository;
import com.lama_b4_g1.backend.repository.EmployeeMasterRepository;
import com.lama_b4_g1.backend.repository.ItemMasterRepository;
import com.lama_b4_g1.backend.repository.LoanCardMasterRepository;
import com.lama_b4_g1.backend.services.EmployeeCardDetailsService;
import com.lama_b4_g1.backend.services.EmployeeIssueDetailsService;
import com.lama_b4_g1.backend.services.EmployeeMasterService;
import com.lama_b4_g1.backend.services.ItemMasterService;
import com.lama_b4_g1.backend.services.LoanCardMasterService;


@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeMasterService employeeService;
	
//	@MockBean
//	private EmployeeMasterRepository employeeRepository;	
//
//	@MockBean
//	private EmployeeCardDetailsService empCardDetailsService;
//	
//	@MockBean
//	private EmployeeCardDetailsRepository empCardDetaillsRepo;
//	
//	@MockBean
//	private  EmployeeIssueDetailsService empIssueDetailsService;
//	
//	@MockBean
//	private EmployeeIssueDetailsRepository empTssueDetailsRepo;
//	
//	@MockBean
//	private LoanCardMasterRepository loanCardMasterRepo;
//	
//	@MockBean
//	private LoanCardMasterService loanCardMasterService;
//	
//	@MockBean
//	private ItemMasterService itemMasterService;
//	
//	@MockBean
//	private ItemMasterRepository itemMasterRepo;
	
	
	
	private static ObjectMapper mapper = new ObjectMapper();

	@Test
//	@Ignore
	public void testGetEmployees() throws Exception {
		EmployeeMaster employee = new EmployeeMaster();
		employee.setEmployeeId("1009");
		employee.setEmployeeName("srisai");
		employee.setGender('m');
		employee.setUserName("shri");
		employee.setPassword("1234");

		List<EmployeeMaster> allEmployees = new ArrayList<>();
		allEmployees.add(employee);

		Mockito.when(employeeService.fetchAllEmployees()).thenReturn(allEmployees);

		System.out.println("test method");
		mvc.perform(get("/getAllEmployees").
				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].employeeName", Matchers.equalTo(employee.getEmployeeName())));
	}

//	@Test
//	@Ignore
//	public void testSaveEmployee() throws Exception {
//		EmployeeMaster employee = new EmployeeMaster();
//		
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2002,11,12);
//		
//		employee.setEmployeeId("1239");
//		employee.setEmployeeName("henry");
//		employee.setUserName("henry");
//		employee.setPassword("1234");
//		employee.setDepartment("tech");
//		employee.setDesignation("clerk");
//		employee.setGender('m');
//		employee.setDob((Date) calendar.getTime());
//		
//		calendar.set(2022,02,10);
//		employee.setDoj((Date) calendar.getTime());
//		
//		
//		Mockito.when(employeeService.saveEmpMaster(ArgumentMatchers.any())).thenReturn(employee);
//		
//		String json = mapper.writeValueAsString(employee);
//		
//		mvc.perform(post("/api/v1/saveEmployee").
//				contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
//				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//
//	}
//	
	
//	@Test
//	public void testGetEmployeById() throws Exception {
//		Employee employee = new Employee();
//		employee.setId(1);
//		employee.setFirstName("sai");
//		employee.setLastName("sri");
//		employee.setEmailId("sri@gmail.com");
//		Mockito.when(employeeService.getEmployee(ArgumentMatchers.anyInt())).thenReturn(employee);
//mvc.perform(get("/api/v1/getEmployee/{id}",1)
//		      .contentType(MediaType.APPLICATION_JSON))
//		      .andExpect(status().isOk()).
//		      andExpect(jsonPath("$.firstName", Matchers.equalTo(employee.getFirstName())));
//	
//	}
//	@Test
//    public void testDeleteEmployee() throws Exception {
//		Employee employee = new Employee();
//		employee.setId(1);
//		employee.setFirstName("sai");
//		employee.setLastName("sri");
//		employee.setEmailId("sri@gmail.com");
//		Mockito.when(employeeService.getEmployee(ArgumentMatchers.anyInt())).thenReturn(employee);
//        employeeService.deleteEmployee(ArgumentMatchers.anyInt());
//        MvcResult requestResult = mvc.perform(delete("/api/v1/deleteEmployee/1"))
//        		.andExpect(status().isOk()).andReturn();
//        String result = requestResult.getResponse().getContentAsString();
//    assertEquals(result, "Employee deleted successfully");
//    }
	/**
	 * @throws Exception
	 */

/*	@Test
	public void testUpdateEmployee() throws Exception {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstName("Minu");
		employee.setLastName("sri");
		employee.setEmailId("minu@gmail.com");
		Mockito.when(employeeService.getEmployee(ArgumentMatchers.anyInt())).thenReturn(employee);
		//Mockito.when(employeeService.updateEmployee(employee));
		String json = mapper.writeValueAsString(employee);
		mvc.perform(put("/api/v1/updateEmployee/1").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
			.andExpect(jsonPath("$.id", Matchers.equalTo(1)))
				.andExpect(jsonPath("$.firstName", Matchers.equalTo("Minu")));
	}

}
*/
