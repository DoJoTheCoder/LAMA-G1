package com.lama_b4_g1.backend.controller;

import static org.mockito.Mockito.when;

import com.lama_b4_g1.backend.services.EmployeeIssueDetailsService;

import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeIssueDetailsController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeIssueDetailsControllerTest {
    @Autowired
    private EmployeeIssueDetailsController employeeIssueDetailsController;

    @MockBean
    private EmployeeIssueDetailsService employeeIssueDetailsService;

    /**
     * Method under test: {@link EmployeeIssueDetailsController#getEmployeePurchasedItems(String)}
     */
    @Test
    public void testGetEmployeePurchasedItems2() throws Exception {
        when(employeeIssueDetailsService.getEmployeeItems(Mockito.<String>any())).thenReturn(new HashSet<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getEmployeeItems/{empId}", "E1002");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeIssueDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

