package com.lama_b4_g1.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.models.ItemMaster;
import com.lama_b4_g1.backend.services.ItemMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ItemMasterController {
	
	@Autowired
	ItemMasterService itemMasterService;
	
	@GetMapping("/getAllItems")
	public List<ItemMaster> getAllItems(){
		return itemMasterService.getAllItems();
	}
	@GetMapping("/getAllItemCategories")
	public List<String> getAllItemCategory(){
		return itemMasterService.getAllItemCategory();
	}
	
	@GetMapping("/getItemMakes/{ic}")
	public List<String> getItemMakes(@PathVariable("ic") String itemCategory){
		return itemMasterService.getItemMakes(itemCategory);
	}
	
	@GetMapping("/getItemDescriptions/{icat}/{imake}")
	public List<String> getItemDescriptions(@PathVariable("imake") String itemMake, @PathVariable("icat") String itemCategory){
		return itemMasterService.getItemDescriptions(itemCategory, itemMake);
	}
	
	@GetMapping("/getItemValue/{idesc}")
	public String getItemValuation(@PathVariable("idesc") String itemDesc) {
		return itemMasterService.getItemValue(itemDesc);
	}
	
	@GetMapping("getItemById/{id}")
	public ItemMaster getItemyId(@PathVariable("id") String id)
	{
		return itemMasterService.getItemById(id);
	}
	
	@PostMapping("/addItemMaster")
	public ItemMaster addingNewItem(@RequestBody ItemMaster itemAdd)
	{
		return itemMasterService.addItemMaster(itemAdd);
	}
	
	@DeleteMapping("/deleteItemRecord/{id}")
	public String deleteItemById(@PathVariable("id") String id) {
		
		return itemMasterService.deleteItemById(id);
	}
}
