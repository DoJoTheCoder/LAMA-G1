package com.lama_b4_g1.backend.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lama_b4_g1.backend.dto.ItemMasterDto;
import com.lama_b4_g1.backend.models.ItemMaster;
import com.lama_b4_g1.backend.services.ItemMasterService;

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

@ContextConfiguration(classes = {ItemMasterController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemMasterControllerTest {
    @Autowired
    private ItemMasterController itemMasterController;

    @MockBean
    private ItemMasterService itemMasterService;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link ItemMasterController#getAllItems()}
     */
    @Test
    public void testGetAllItems2() throws Exception {
        ItemMaster itemMaster = new ItemMaster();
        itemMaster.setEmpIssueDetails(new HashSet<>());
        itemMaster.setIssueStatus('Y');
        itemMaster.setItemCategory("Furniture");
        itemMaster.setItemDescription("TeaTable");
        itemMaster.setItemId("IT01");
        itemMaster.setItemMake("Wood");
        itemMaster.setItemValuation(400);

        ArrayList<ItemMaster> itemMasterList = new ArrayList<>();
        itemMasterList.add(itemMaster);
        when(itemMasterService.getAllItems()).thenReturn(itemMasterList);

        ItemMasterDto itemMasterDto = new ItemMasterDto();
        itemMasterDto.setIssueStatus('Y');
        itemMasterDto.setItemCategory("Furniture");
        itemMasterDto.setItemDescription("TeaTable");
        itemMasterDto.setItemId("IT01");
        itemMasterDto.setItemMake("Wood");
        itemMasterDto.setItemValuation(400);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<ItemMasterDto>>any())).thenReturn(itemMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllItems");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"itemId\":\"IT01\",\"itemDescription\":\"TeaTable\",\"issueStatus\":\"Y\",\"itemMake\":\"Wood\","
                                        + "\"itemCategory\":\"Furniture\",\"itemValuation\":400}]"));
    }

    /**
     * Method under test: {@link ItemMasterController#getAllItems()}
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
     * Method under test: {@link ItemMasterController#getItemMakes(String)}
     */
    @Test
    public void testGetItemMakes() throws Exception {
        when(itemMasterService.getItemMakes(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItemMakes/{ic}", "Ic");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ItemMasterController#getItemMakes(String)}
     */
    @Test
    public void testGetItemDescriptions() throws Exception {
        when(itemMasterService.getItemDescriptions(Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItemDescriptions/{icat}/{imake}",
                "Icat", "Imake");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ItemMasterController#getItemDescriptions(String, String)}
     */
    @Test
    public void testAddingNewItem() throws Exception {
        ItemMaster itemMaster = new ItemMaster();
        itemMaster.setEmpIssueDetails(new HashSet<>());
        itemMaster.setIssueStatus('Y');
        itemMaster.setItemCategory("Crockery");
        itemMaster.setItemDescription("Tea Set");
        itemMaster.setItemId("IT02");
        itemMaster.setItemMake("Ceramic");
        itemMaster.setItemValuation(4200);
        when(itemMasterService.addItemMaster(Mockito.<ItemMaster>any())).thenReturn(itemMaster);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(null);

        ItemMasterDto itemMasterDto = new ItemMasterDto();
        itemMasterDto.setIssueStatus('A');
        itemMasterDto.setItemCategory("Crockery");
        itemMasterDto.setItemDescription("Tet Set");
        itemMasterDto.setItemId("IT02");
        itemMasterDto.setItemMake("Ceramic");
        itemMasterDto.setItemValuation(4200);
        String content = (new ObjectMapper()).writeValueAsString(itemMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addItemMaster")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ItemMasterController#deleteItemById(String)}
     */
    @Test
    public void testDeleteItemById() throws Exception {
        when(itemMasterService.deleteItemById(Mockito.<String>any())).thenReturn("Deletion Sucess");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteItemRecord/{id}", "42");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deletion Sucess"));
    }

    /**
     * Method under test: {@link ItemMasterController#deleteItemById(String)}
     */
    @Test
    public void testGetItemValuation() throws Exception {
        when(itemMasterService.getItemValue(Mockito.<String>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItemValue/{idesc}", "Idesc");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link ItemMasterController#getItemValuation(String)}
     */
    @Test
    public void testGetItemyId() throws Exception {
        ItemMaster itemMaster = new ItemMaster();
        itemMaster.setEmpIssueDetails(new HashSet<>());
        itemMaster.setIssueStatus('Y');
        itemMaster.setItemCategory("Plastic");
        itemMaster.setItemDescription("Chair");
        itemMaster.setItemId("IT03");
        itemMaster.setItemMake("Plastic");
        itemMaster.setItemValuation(42);
        when(itemMasterService.getItemById(Mockito.<String>any())).thenReturn(itemMaster);

        ItemMasterDto itemMasterDto = new ItemMasterDto();
        itemMasterDto.setIssueStatus('Y');
        itemMasterDto.setItemCategory("Plastic");
        itemMasterDto.setItemDescription("Chair");
        itemMasterDto.setItemId("IT03");
        itemMasterDto.setItemMake("Plastic");
        itemMasterDto.setItemValuation(42);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<ItemMasterDto>>any())).thenReturn(itemMasterDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItemById/{id}", "IT03");
        MockMvcBuilders.standaloneSetup(itemMasterController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"itemId\":\"IT03\",\"itemDescription\":\"Chair\",\"issueStatus\":\"Y\",\"itemMake\":\"Plastic\",\"itemCategory"
                                        + "\":\"Plastic\",\"itemValuation\":42}"));
    }
}

