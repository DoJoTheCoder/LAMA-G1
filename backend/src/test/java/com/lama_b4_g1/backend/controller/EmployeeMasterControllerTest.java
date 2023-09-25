package com.lama_b4_g1.backend.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lama_b4_g1.backend.models.EmployeeLoginCredentials;
import com.lama_b4_g1.backend.models.EmployeeMaster;
import com.lama_b4_g1.backend.models.NewLoanInfo;
import com.lama_b4_g1.backend.repository.EmployeeCardDetailsRepository;
import com.lama_b4_g1.backend.services.EmployeeCardDetailsService;
import com.lama_b4_g1.backend.services.EmployeeMasterService;
import com.lama_b4_g1.backend.services.LoanCardMasterService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeMasterController.class})
@ExtendWith(SpringExtension.class)
class EmployeeMasterControllerTest {
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

    /**
     * Method under test: {@link EmployeeMasterController#addEmpMaster(EmployeeMaster)}
     */
    @Test
    void testAddEmpMaster2() throws Exception {
        Date dob = mock(Date.class);
        when(dob.getTime()).thenReturn(10L);
        Date doj = mock(Date.class);
        when(doj.getTime()).thenReturn(10L);

        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setAccessType("Access Type");
        employeeMaster.setDepartment("Department");
        employeeMaster.setDesignation("Designation");
        employeeMaster.setDob(dob);
        employeeMaster.setDoj(doj);
        employeeMaster.setEmpCardDetails(new HashSet<>());
        employeeMaster.setEmpIssueDetails(new HashSet<>());
        employeeMaster.setEmployeeId("42");
        employeeMaster.setEmployeeName("Employee Name");
        employeeMaster.setGender('A');
        employeeMaster.setPassword("iloveyou");
        employeeMaster.setUserName("janedoe");
        when(employeeMasterService.saveEmpMaster(Mockito.<EmployeeMaster>any())).thenReturn(employeeMaster);
        Date dob2 = mock(Date.class);
        when(dob2.getTime()).thenReturn(10L);
        Date doj2 = mock(Date.class);
        when(doj2.getTime()).thenReturn(10L);

        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        employeeMaster2.setAccessType("Access Type");
        employeeMaster2.setDepartment("Department");
        employeeMaster2.setDesignation("Designation");
        employeeMaster2.setDob(dob2);
        employeeMaster2.setDoj(doj2);
        employeeMaster2.setEmpCardDetails(new HashSet<>());
        employeeMaster2.setEmpIssueDetails(new HashSet<>());
        employeeMaster2.setEmployeeId("42");
        employeeMaster2.setEmployeeName("Employee Name");
        employeeMaster2.setGender('A');
        employeeMaster2.setPassword("iloveyou");
        employeeMaster2.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(employeeMaster2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addEmployeeMaster")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"employeeId\":\"42\",\"employeeName\":\"Employee Name\",\"designation\":\"Designation\",\"department\":\"Department"
                                        + "\",\"gender\":\"A\",\"userName\":\"janedoe\",\"password\":\"iloveyou\",\"dob\":10,\"doj\":10,\"accessType\":\"Access"
                                        + " Type\",\"empCardDetails\":[],\"empIssueDetails\":[]}"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#editEmpRecord(String, EmployeeMaster)}
     */
    @Test
    void testEditEmpRecord2() throws Exception {
        when(employeeMasterService.editRecord(Mockito.<String>any(), Mockito.<EmployeeMaster>any()))
                .thenReturn("Edit Record");
        Date dob = mock(Date.class);
        when(dob.getTime()).thenReturn(10L);
        Date doj = mock(Date.class);
        when(doj.getTime()).thenReturn(10L);

        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setAccessType("Access Type");
        employeeMaster.setDepartment("Department");
        employeeMaster.setDesignation("Designation");
        employeeMaster.setDob(dob);
        employeeMaster.setDoj(doj);
        employeeMaster.setEmpCardDetails(new HashSet<>());
        employeeMaster.setEmpIssueDetails(new HashSet<>());
        employeeMaster.setEmployeeId("42");
        employeeMaster.setEmployeeName("Employee Name");
        employeeMaster.setGender('A');
        employeeMaster.setPassword("iloveyou");
        employeeMaster.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(employeeMaster);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/editEmpRecord/{id}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Edit Record"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#findEmpById(String)}
     */
    @Test
    void testFindEmpById() throws Exception {
        Date dob = mock(Date.class);
        when(dob.getTime()).thenReturn(10L);
        Date doj = mock(Date.class);
        when(doj.getTime()).thenReturn(10L);

        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setAccessType("Access Type");
        employeeMaster.setDepartment("Department");
        employeeMaster.setDesignation("Designation");
        employeeMaster.setDob(dob);
        employeeMaster.setDoj(doj);
        employeeMaster.setEmpCardDetails(new HashSet<>());
        employeeMaster.setEmpIssueDetails(new HashSet<>());
        employeeMaster.setEmployeeId("42");
        employeeMaster.setEmployeeName("Employee Name");
        employeeMaster.setGender('A');
        employeeMaster.setPassword("iloveyou");
        employeeMaster.setUserName("janedoe");
        when(employeeMasterService.findEmpById(Mockito.<String>any())).thenReturn(employeeMaster);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/findEmp/{id}", "42");
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"employeeId\":\"42\",\"employeeName\":\"Employee Name\",\"designation\":\"Designation\",\"department\":\"Department"
                                        + "\",\"gender\":\"A\",\"userName\":\"janedoe\",\"password\":\"iloveyou\",\"dob\":10,\"doj\":10,\"accessType\":\"Access"
                                        + " Type\",\"empCardDetails\":[],\"empIssueDetails\":[]}"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#deleteEmpById(String)}
     */
    @Test
    void testDeleteEmpById() throws Exception {
        when(employeeMasterService.deleteEmpById(Mockito.<String>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteEmp/{id}", "42");
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#deleteEmpById(String)}
     */
    @Test
    void testDeleteEmpById2() throws Exception {
        when(employeeMasterService.deleteEmpById(Mockito.<String>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteEmp/{id}", "42");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#addEmpMaster(EmployeeMaster)}
     */
    @Test
    void testAddEmpMaster() throws Exception {
        Date dob = mock(Date.class);
        when(dob.getTime()).thenReturn(10L);
        Date doj = mock(Date.class);
        when(doj.getTime()).thenReturn(10L);

        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setAccessType("Access Type");
        employeeMaster.setDepartment("Department");
        employeeMaster.setDesignation("Designation");
        employeeMaster.setDob(dob);
        employeeMaster.setDoj(doj);
        employeeMaster.setEmpCardDetails(new HashSet<>());
        employeeMaster.setEmpIssueDetails(new HashSet<>());
        employeeMaster.setEmployeeId("42");
        employeeMaster.setEmployeeName("Employee Name");
        employeeMaster.setGender('A');
        employeeMaster.setPassword("iloveyou");
        employeeMaster.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(employeeMaster);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addEmployeeMaster")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }

    /**
     * Method under test: {@link EmployeeMasterController#addNewLoanData(NewLoanInfo)}
     */
    @Test
    void testAddNewLoanData() throws Exception {
        when(employeeMasterService.addNewLoanData(Mockito.<NewLoanInfo>any())).thenReturn("Add New Loan Data");

        NewLoanInfo newLoanInfo = new NewLoanInfo();
        newLoanInfo.setEmployeeId("42");
        newLoanInfo.setItemDescription("Item Description");
        String content = (new ObjectMapper()).writeValueAsString(newLoanInfo);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addNewLoan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Add New Loan Data"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#editEmpRecord(String, EmployeeMaster)}
     */
    @Test
    void testEditEmpRecord() throws Exception {
        Date dob = mock(Date.class);
        when(dob.getTime()).thenReturn(10L);
        Date doj = mock(Date.class);
        when(doj.getTime()).thenReturn(10L);

        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setAccessType("Access Type");
        employeeMaster.setDepartment("Department");
        employeeMaster.setDesignation("Designation");
        employeeMaster.setDob(dob);
        employeeMaster.setDoj(doj);
        employeeMaster.setEmpCardDetails(new HashSet<>());
        employeeMaster.setEmpIssueDetails(new HashSet<>());
        employeeMaster.setEmployeeId("42");
        employeeMaster.setEmployeeName("Employee Name");
        employeeMaster.setGender('A');
        employeeMaster.setPassword("iloveyou");
        employeeMaster.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(employeeMaster);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/editEmpRecord/{id}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }

    /**
     * Method under test: {@link EmployeeMasterController#getLoanList(Map)}
     */
    @Test
    void testGetLoanList() throws Exception {
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
    void testLoginEmployee() throws Exception {
        when(employeeMasterService.authenticateEmployee(Mockito.<EmployeeLoginCredentials>any()))
                .thenReturn(new ArrayList<>());

        EmployeeLoginCredentials employeeLoginCredentials = new EmployeeLoginCredentials();
        employeeLoginCredentials.setPassword("iloveyou");
        employeeLoginCredentials.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(employeeLoginCredentials);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/validateLogin")
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
     * Method under test: {@link EmployeeMasterController#viewEmpRecords()}
     */
    @Test
    void testViewEmpRecords() throws Exception {
        when(employeeMasterService.viewEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/viewEmpRecords");
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeMasterController#viewEmpRecords()}
     */
    @Test
    void testViewEmpRecords2() throws Exception {
        when(employeeMasterService.viewEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/viewEmpRecords");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

