package com.lama_b4_g1.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.models.ItemMaster;
import com.lama_b4_g1.backend.services.ItemMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ItemMasterController {
	
	@Autowired
	ItemMasterService itemMasterService;
	
	@GetMapping("/getAllItemCategories")
	public List<String> getAllItemCategory(){
		return itemMasterService.getAllItemCategory();
	}
}
