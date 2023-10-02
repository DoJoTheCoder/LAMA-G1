package com.lama_b4_g1.backend.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lama_b4_g1.backend.dto.LoanCardMasterDto;
import com.lama_b4_g1.backend.models.LoanCardMaster;
import com.lama_b4_g1.backend.services.LoanCardMasterService;

import java.util.ArrayList;

import java.util.HashSet;

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

@ContextConfiguration(classes = {LoanCardMasterController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LoanCardMasterControllerTest {
    @Autowired
    private LoanCardMasterController loanCardMasterController;

    @MockBean
    private LoanCardMasterService loanCardMasterService;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link LoanCardMasterController#addNewLoanCard(LoanCardMasterDto)}
     */
    @Test
    public void testAddNewLoanCard() throws Exception {
        LoanCardMaster loanCardMaster = new LoanCardMaster();
        loanCardMaster.setDurationInYears(1);
        loanCardMaster.setEmpCardDetail(new HashSet<>());
        loanCardMaster.setLoanId("42");
        loanCardMaster.setLoanType("Loan Type");
        when(loanCardMasterService.addNewLoanCard(Mockito.<LoanCardMaster>any())).thenReturn(loanCardMaster);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(null);

        LoanCardMasterDto loanCardMasterDto = new LoanCardMasterDto();
        loanCardMasterDto.setDurationInYears(1);
        loanCardMasterDto.setLoanId("42");
        loanCardMasterDto.setLoanType("Loan Type");
        String content = (new ObjectMapper()).writeValueAsString(loanCardMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addLoanCardMaster")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(loanCardMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link LoanCardMasterController#saveLoan(LoanCardMasterDto)}
     */
    @Test
    public void testSaveLoan() throws Exception {
        when(loanCardMasterService.saveLoan(Mockito.<LoanCardMaster>any())).thenReturn("Save Loan");

        LoanCardMaster loanCardMaster = new LoanCardMaster();
        loanCardMaster.setDurationInYears(1);
        loanCardMaster.setEmpCardDetail(new HashSet<>());
        loanCardMaster.setLoanId("42");
        loanCardMaster.setLoanType("Loan Type");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<LoanCardMaster>>any())).thenReturn(loanCardMaster);

        LoanCardMasterDto loanCardMasterDto = new LoanCardMasterDto();
        loanCardMasterDto.setDurationInYears(1);
        loanCardMasterDto.setLoanId("42");
        loanCardMasterDto.setLoanType("Loan Type");
        String content = (new ObjectMapper()).writeValueAsString(loanCardMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveLoan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(loanCardMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Save Loan"));
    }

    /**
     * Method under test: {@link LoanCardMasterController#editLoan(String, LoanCardMasterDto)}
     */
    @Test
    public void testEditLoan() throws Exception {
        when(loanCardMasterService.editLoan(Mockito.<String>any(), Mockito.<LoanCardMaster>any()))
                .thenReturn("Edit Loan");

        LoanCardMaster loanCardMaster = new LoanCardMaster();
        loanCardMaster.setDurationInYears(1);
        loanCardMaster.setEmpCardDetail(new HashSet<>());
        loanCardMaster.setLoanId("42");
        loanCardMaster.setLoanType("Loan Type");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<LoanCardMaster>>any())).thenReturn(loanCardMaster);

        LoanCardMasterDto loanCardMasterDto = new LoanCardMasterDto();
        loanCardMasterDto.setDurationInYears(1);
        loanCardMasterDto.setLoanId("42");
        loanCardMasterDto.setLoanType("Loan Type");
        String content = (new ObjectMapper()).writeValueAsString(loanCardMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/editLoan/{id}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(loanCardMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Edit Loan"));
    }

    /**
     * Method under test: {@link LoanCardMasterController#findLoanById(String)}
     */
    @Test
    public void testFindLoanById() throws Exception {
        LoanCardMaster loanCardMaster = new LoanCardMaster();
        loanCardMaster.setDurationInYears(1);
        loanCardMaster.setEmpCardDetail(new HashSet<>());
        loanCardMaster.setLoanId("42");
        loanCardMaster.setLoanType("Loan Type");
        when(loanCardMasterService.findLoanById(Mockito.<String>any())).thenReturn(loanCardMaster);

        LoanCardMasterDto loanCardMasterDto = new LoanCardMasterDto();
        loanCardMasterDto.setDurationInYears(1);
        loanCardMasterDto.setLoanId("42");
        loanCardMasterDto.setLoanType("Loan Type");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<LoanCardMasterDto>>any()))
                .thenReturn(loanCardMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/findLoan/{id}", "42");
        MockMvcBuilders.standaloneSetup(loanCardMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"loanId\":\"42\",\"loanType\":\"Loan Type\",\"durationInYears\":1}"));
    }

    /**
     * Method under test: {@link LoanCardMasterController#deleteById(String)}
     */
    @Test
    public void testDeleteById() throws Exception {
        when(loanCardMasterService.deleteLoanById(Mockito.<String>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteLoanCard/{id}", "42");
        MockMvcBuilders.standaloneSetup(loanCardMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link LoanCardMasterController#deleteById(String)}
     */
    @Test
    public void testDeleteById2() throws Exception {
        when(loanCardMasterService.deleteLoanById(Mockito.<String>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteLoanCard/{id}", "42");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(loanCardMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link LoanCardMasterController#getAllLoanCards()}
     */
    @Test
    public void testGetAllLoanCards() throws Exception {
        when(loanCardMasterService.getAllLoans()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getLoanMasterList");
        MockMvcBuilders.standaloneSetup(loanCardMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link LoanCardMasterController#getAllLoanCards()}
     */
    @Test
    public void testGetAllLoanCards2() throws Exception {
        LoanCardMaster loanCardMaster = new LoanCardMaster();
        loanCardMaster.setDurationInYears(1);
        loanCardMaster.setEmpCardDetail(new HashSet<>());
        loanCardMaster.setLoanId("42");
        loanCardMaster.setLoanType("?");

        ArrayList<LoanCardMaster> loanCardMasterList = new ArrayList<>();
        loanCardMasterList.add(loanCardMaster);
        when(loanCardMasterService.getAllLoans()).thenReturn(loanCardMasterList);

        LoanCardMasterDto loanCardMasterDto = new LoanCardMasterDto();
        loanCardMasterDto.setDurationInYears(1);
        loanCardMasterDto.setLoanId("42");
        loanCardMasterDto.setLoanType("Loan Type");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<LoanCardMasterDto>>any()))
                .thenReturn(loanCardMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getLoanMasterList");
        MockMvcBuilders.standaloneSetup(loanCardMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"loanId\":\"42\",\"loanType\":\"Loan Type\",\"durationInYears\":1}]"));
    }

    /**
     * Method under test: {@link LoanCardMasterController#getAllLoanCards()}
     */
    @Test
    public void testGetAllLoanCards3() throws Exception {
        LoanCardMaster loanCardMaster = new LoanCardMaster();
        loanCardMaster.setDurationInYears(1);
        loanCardMaster.setEmpCardDetail(new HashSet<>());
        loanCardMaster.setLoanId("42");
        loanCardMaster.setLoanType("?");

        LoanCardMaster loanCardMaster2 = new LoanCardMaster();
        loanCardMaster2.setDurationInYears(0);
        loanCardMaster2.setEmpCardDetail(new HashSet<>());
        loanCardMaster2.setLoanId("?");
        loanCardMaster2.setLoanType("Loan Type");

        ArrayList<LoanCardMaster> loanCardMasterList = new ArrayList<>();
        loanCardMasterList.add(loanCardMaster2);
        loanCardMasterList.add(loanCardMaster);
        when(loanCardMasterService.getAllLoans()).thenReturn(loanCardMasterList);

        LoanCardMasterDto loanCardMasterDto = new LoanCardMasterDto();
        loanCardMasterDto.setDurationInYears(1);
        loanCardMasterDto.setLoanId("42");
        loanCardMasterDto.setLoanType("Loan Type");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<LoanCardMasterDto>>any()))
                .thenReturn(loanCardMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getLoanMasterList");
        MockMvcBuilders.standaloneSetup(loanCardMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"loanId\":\"42\",\"loanType\":\"Loan Type\",\"durationInYears\":1},{\"loanId\":\"42\",\"loanType\":\"Loan"
                                        + " Type\",\"durationInYears\":1}]"));
    }
}

