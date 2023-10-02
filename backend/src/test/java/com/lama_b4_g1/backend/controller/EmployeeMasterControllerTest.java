package com.lama_b4_g1.backend.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lama_b4_g1.backend.dto.EmployeeMasterDto;
import com.lama_b4_g1.backend.models.EmployeeLoginCredentials;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.models.NewLoanInfo;
import com.lama_b4_g1.backend.repository.EmployeeCardDetailsRepository;
import com.lama_b4_g1.backend.services.EmployeeCardDetailsService;
import com.lama_b4_g1.backend.services.EmployeeMasterService;
import com.lama_b4_g1.backend.services.LoanCardMasterService;

import java.sql.Date;
import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeMasterController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeMasterControllerTest {
    @MockBean
    private EmployeeCardDetailsRepository employeeCardDetailsRepository;

    @MockBean
    private EmployeeCardDetailsService employeeCardDetailsService;

    @Autowired
    private EmployeeMasterController employeeMasterController;

    @MockBean
    private EmployeeMasterService employeeMasterService;

    @MockBean
    private LoanCardMasterService loanCardMasterService;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link EmployeeMasterController#findEmpById(String)}
     */
    @Test
    public void testFindEmpById() throws Exception {
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setAccessType("User");
        employeeMaster.setDepartment("Technology");
        employeeMaster.setDesignation("Manager");
        employeeMaster.setDob(mock(Date.class));
        employeeMaster.setDoj(mock(Date.class));
        employeeMaster.setEmpCardDetails(new HashSet<>());
        employeeMaster.setEmpIssueDetails(new HashSet<>());
        employeeMaster.setEmployeeId("E1012");
        employeeMaster.setEmployeeName("Kennedy");
        employeeMaster.setGender('M');
        employeeMaster.setPassword("1234");
        employeeMaster.setUserName("Ken");
        when(employeeMasterService.findEmpById(Mockito.<String>any())).thenReturn(employeeMaster);
        Date dob = mock(Date.class);
        when(dob.getTime()).thenReturn(10L);
        Date doj = mock(Date.class);
        when(doj.getTime()).thenReturn(10L);

        EmployeeMasterDto employeeMasterDto = new EmployeeMasterDto();
        employeeMasterDto.setAccessType("User");
        employeeMasterDto.setDepartment("Technology");
        employeeMasterDto.setDesignation("Manager");
        employeeMasterDto.setDob(dob);
        employeeMasterDto.setDoj(doj);
        employeeMasterDto.setEmployeeId("E1012");
        employeeMasterDto.setEmployeeName("Kennedy");
        employeeMasterDto.setGender('M');
        employeeMasterDto.setPassword("1234");
        employeeMasterDto.setUserName("Ken");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<EmployeeMasterDto>>any()))
                .thenReturn(employeeMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/findEmp/{id}", "42");
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"employeeId\":\"E1012\",\"employeeName\":\"Kennedy\",\"designation\":\"Manager\",\"department\":\"Technology"
                                        + "\",\"gender\":\"M\",\"userName\":\"Ken\",\"password\":\"1234\",\"dob\":10,\"doj\":10,\"accessType\":\"User\"}"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#deleteEmpById(String)}
     */
    @Test
    public void testDeleteEmpById() throws Exception {
        when(employeeMasterService.deleteEmpById(Mockito.<String>any())).thenReturn("Sucessfully Deleted");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteEmp/{id}", "E1002");
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Sucessfully Deleted"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#deleteEmpById(String)}
     */
    @Test
    public void testAddEmpMaster() throws Exception {
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setAccessType("User");
        employeeMaster.setDepartment("Technology");
        employeeMaster.setDesignation("Program Associate");
        employeeMaster.setDob(mock(Date.class));
        employeeMaster.setDoj(mock(Date.class));
        employeeMaster.setEmpCardDetails(new HashSet<>());
        employeeMaster.setEmpIssueDetails(new HashSet<>());
        employeeMaster.setEmployeeId("E1002");
        employeeMaster.setEmployeeName("Flanagan");
        employeeMaster.setGender('F');
        employeeMaster.setPassword("pass123");
        employeeMaster.setUserName("Flan");
        when(employeeMasterService.saveEmpMaster(Mockito.<EmployeeMaster>any())).thenReturn(employeeMaster);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(null);
        Date dob = mock(Date.class);
        when(dob.getTime()).thenReturn(10L);
        Date doj = mock(Date.class);
        when(doj.getTime()).thenReturn(10L);

        EmployeeMasterDto employeeMasterDto = new EmployeeMasterDto();
        employeeMasterDto.setAccessType("User");
        employeeMasterDto.setDepartment("Technology");
        employeeMasterDto.setDesignation("Program Associate");
        employeeMasterDto.setDob(dob);
        employeeMasterDto.setDoj(doj);
        employeeMasterDto.setEmployeeId("E1002");
        employeeMasterDto.setEmployeeName("Flanagan");
        employeeMasterDto.setGender('F');
        employeeMasterDto.setPassword("pass123");
        employeeMasterDto.setUserName("Flan");
        String content = (new ObjectMapper()).writeValueAsString(employeeMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addEmployeeMaster")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link EmployeeMasterController#addNewLoanData(NewLoanInfo)}
     */
    @Test
    public void testAddNewLoanData() throws Exception {
        when(employeeMasterService.addNewLoanData(Mockito.<NewLoanInfo>any())).thenReturn("Added New Loan Data");

        NewLoanInfo newLoanInfo = new NewLoanInfo();
        newLoanInfo.setEmployeeId("E1002");
        newLoanInfo.setItemDescription("Tea Table");
        String content = (new ObjectMapper()).writeValueAsString(newLoanInfo);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addNewLoan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Added New Loan Data"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#editEmpRecord(String, EmployeeMasterDto)}
     */
    @Test
    public void testEditEmpRecord() throws Exception {
        when(employeeMasterService.editRecord(Mockito.<String>any(), Mockito.<EmployeeMaster>any()))
                .thenReturn("Edit Record Sucess");

        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setAccessType("User");
        employeeMaster.setDepartment("Technology");
        employeeMaster.setDesignation("Manager");
        employeeMaster.setDob(mock(Date.class));
        employeeMaster.setDoj(mock(Date.class));
        employeeMaster.setEmpCardDetails(new HashSet<>());
        employeeMaster.setEmpIssueDetails(new HashSet<>());
        employeeMaster.setEmployeeId("E1002");
        employeeMaster.setEmployeeName("Johnny");
        employeeMaster.setGender('M');
        employeeMaster.setPassword("1234");
        employeeMaster.setUserName("John");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<EmployeeMaster>>any())).thenReturn(employeeMaster);
        Date dob = mock(Date.class);
        when(dob.getTime()).thenReturn(10L);
        Date doj = mock(Date.class);
        when(doj.getTime()).thenReturn(10L);

        EmployeeMasterDto employeeMasterDto = new EmployeeMasterDto();
        employeeMasterDto.setAccessType("User");
        employeeMasterDto.setDepartment("Technology");
        employeeMasterDto.setDesignation("Manager");
        employeeMasterDto.setDob(dob);
        employeeMasterDto.setDoj(doj);
        employeeMasterDto.setEmployeeId("E1002");
        employeeMasterDto.setEmployeeName("Johnny");
        employeeMasterDto.setGender('M');
        employeeMasterDto.setPassword("1234");
        employeeMasterDto.setUserName("John");
        String content = (new ObjectMapper()).writeValueAsString(employeeMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/editEmpRecord/{id}", "E1002")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Edit Record Sucess"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#getLoanList(Map)}
     */
    @Test
    public void testGetLoanList() throws Exception {
        when(employeeCardDetailsRepository.getLoanListById(Mockito.<String>any())).thenReturn(new ArrayList<>());

        HashMap<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put((String) "searchId", "foo");
        String content = (new ObjectMapper()).writeValueAsString(stringStringMap);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getLoanList")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#loginEmployee(EmployeeLoginCredentials)}
     */
    @Test
    public void testLoginEmployee() throws Exception {
        List<String> response = new ArrayList<>();
        response.add("HelloWorld");
        when(employeeMasterService.authenticateEmployee(Mockito.<EmployeeLoginCredentials>any()))
                .thenReturn(response);

        EmployeeLoginCredentials employeeLoginCredentials = new EmployeeLoginCredentials();
        employeeLoginCredentials.setPassword("1234");
        employeeLoginCredentials.setUserName("Kiel");
        String content = (new ObjectMapper()).writeValueAsString(employeeLoginCredentials);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/validateLogin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[\"HelloWorld\"]"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#viewEmpRecords()}
     */
    @Test
    public void testViewEmpRecords() throws Exception {
        when(employeeMasterService.viewEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/viewEmpRecords");
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

