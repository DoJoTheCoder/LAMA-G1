package com.lama_b4_g1.backend.controller;

import static org.mockito.Mockito.when;

import com.lama_b4_g1.backend.services.ItemMasterService;

import java.util.ArrayList;

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

@ContextConfiguration(classes = {ItemMasterController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemMasterControllerTest {
    @Autowired
    private ItemMasterController itemMasterController;

    @MockBean
    private ItemMasterService itemMasterService;

    /**
     * Method under test: {@link ItemMasterController#getAllItemCategory()}
     */
    @Test
    public void testGetAllItemCategory() throws Exception {
        when(itemMasterService.getAllItemCategory()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllItemCategories");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ItemMasterController#getAllItemCategory()}
     */
    @Test
    public void testGetAllItemCategory2() throws Exception {
        when(itemMasterService.getAllItemCategory()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllItemCategories");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ItemMasterController#deleteItemById(String)}
     */
    @Test
    public void testDeleteItemById() throws Exception {
        when(itemMasterService.deleteItemById(Mockito.<String>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteItemRecord/{id}", "42");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link ItemMasterController#deleteItemById(String)}
     */
    @Test
    public void testDeleteItemById2() throws Exception {
        when(itemMasterService.deleteItemById(Mockito.<String>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteItemRecord/{id}", "42");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }
}

