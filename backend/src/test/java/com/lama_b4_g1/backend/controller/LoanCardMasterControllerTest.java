package com.lama_b4_g1.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lama_b4_g1.backend.models.EmployeeCardDetails;
import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.services.LoanCardMasterService;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {LoanCardMasterController.class})
@ExtendWith(SpringExtension.class)
class LoanCardMasterControllerTest {
    @Autowired
    private LoanCardMasterController loanCardMasterController;

    @MockBean
    private LoanCardMasterService loanCardMasterService;

    /**
     * Method under test: {@link LoanCardMasterController#addNewLoanCard(LoanCardMaster)}
     */
    @Test
    void testAddNewLoanCard() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/addLoanCardMaster", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        LoanCardMaster loanCardMaster = new LoanCardMaster();
        loanCardMaster.setDurationInYears(1);
        HashSet<EmployeeCardDetails> empCardDetail = new HashSet<>();
        loanCardMaster.setEmpCardDetail(empCardDetail);
        loanCardMaster.setLoanId("42");
        loanCardMaster.setLoanType("Loan Type");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(loanCardMaster));
        Object[] controllers = new Object[]{loanCardMasterController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LoanCardMasterController#deleteById(String)}
     */
    @Test
    void testDeleteById() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{"42"};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteLoanCard/{id}",
                uriVariables);
        Object[] controllers = new Object[]{loanCardMasterController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LoanCardMasterController#editLoan(String, LoanCardMaster)}
     */
    @Test
    void testEditLoan() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{"42"};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/editLoan/{id}", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        LoanCardMaster loanCardMaster = new LoanCardMaster();
        loanCardMaster.setDurationInYears(1);
        HashSet<EmployeeCardDetails> empCardDetail = new HashSet<>();
        loanCardMaster.setEmpCardDetail(empCardDetail);
        loanCardMaster.setLoanId("42");
        loanCardMaster.setLoanType("Loan Type");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(loanCardMaster));
        Object[] controllers = new Object[]{loanCardMasterController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LoanCardMasterController#findLoanById(String)}
     */
    @Test
    void testFindLoanById() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{"42"};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/findLoan/{id}", uriVariables);
        Object[] controllers = new Object[]{loanCardMasterController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LoanCardMasterController#getAllLoanCards()}
     */
    @Test
    void testGetAllLoanCards() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getLoanMasterList", uriVariables);
        Object[] controllers = new Object[]{loanCardMasterController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LoanCardMasterController#saveLoan(LoanCardMaster)}
     */
    @Test
    void testSaveLoan() throws Exception {
        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/saveLoan", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        LoanCardMaster loanCardMaster = new LoanCardMaster();
        loanCardMaster.setDurationInYears(1);
        HashSet<EmployeeCardDetails> empCardDetail = new HashSet<>();
        loanCardMaster.setEmpCardDetail(empCardDetail);
        loanCardMaster.setLoanId("42");
        loanCardMaster.setLoanType("Loan Type");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(loanCardMaster));
        Object[] controllers = new Object[]{loanCardMasterController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }
}

