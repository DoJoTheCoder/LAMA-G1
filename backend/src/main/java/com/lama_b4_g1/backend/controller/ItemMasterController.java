package com.lama_b4_g1.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lama_b4_g1.backend.dto.ItemMasterDto;
import com.lama_b4_g1.backend.models.ItemMaster;
import com.lama_b4_g1.backend.services.ItemMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ItemMasterController {
	
	@Autowired
	ItemMasterService itemMasterService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/getAllItems")
	public List<ItemMasterDto> getAllItems(){
		//return itemMasterService.getAllItems();
		
		List<ItemMasterDto> id = itemMasterService.getAllItems().stream().map(i->modelMapper.
				map(i, ItemMasterDto.class)).
				collect(Collectors.toList());
		return id;
//		return itemMasterService.getAllItems().stream().map(i->modelMapper.
//				map(i, ItemMasterDto.class)).
//				collect(Collectors.toList());
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
	public ItemMasterDto getItemyId(@PathVariable("id") String id)
	{
		ItemMaster ims = itemMasterService.getItemById(id);
		return modelMapper.map(ims, ItemMasterDto.class);
	}
	
	@PostMapping("/addItemMaster")
	public ItemMasterDto addingNewItem(@RequestBody ItemMasterDto itemAdd) {
		ItemMaster im1 = modelMapper.map(itemAdd,ItemMaster.class);
		ItemMaster im= itemMasterService.addItemMaster(im1);
		return modelMapper.map(im, ItemMasterDto.class);
	}
	
	@DeleteMapping("/deleteItemRecord/{id}")
	public String deleteItemById(@PathVariable("id") String id) {
		
		return itemMasterService.deleteItemById(id);
	}
}
