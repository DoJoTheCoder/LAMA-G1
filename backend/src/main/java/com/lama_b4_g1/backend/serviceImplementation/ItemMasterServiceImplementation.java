package com.lama_b4_g1.backend.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.ItemMaster;
import com.lama_b4_g1.backend.repository.ItemMasterRepository;
import com.lama_b4_g1.backend.services.ItemMasterService;

@Service
public class ItemMasterServiceImplementation implements ItemMasterService{
	
	@Autowired
	ItemMasterRepository itemMasterRepo;
	
	
	public List<String> getAllItemCategory() {
		return itemMasterRepo.findDistinctByItemCategories();
	}
	
	public List<String> getItemMakes(String itemCategory){
		return itemMasterRepo.findDistinctByItemMakes(itemCategory);
	}
	
	public List<String> getItemDescriptions(String itemCategory, String itemMake){
		return itemMasterRepo.findItemDescriptions(itemCategory, itemMake);
	}
	
	public String getItemValue(String itemDesc) {
		return itemMasterRepo.findItemValue(itemDesc);
	}

	public ItemMaster addItemMaster(ItemMaster itemAdd) {
		ItemMaster obj = null;
		String Id = itemAdd.getItemId();
		Optional<ItemMaster> item = itemMasterRepo.findById(Id);
		if(item.isPresent())
		{
			itemAdd.setEmpIssueDetails(item.get().getEmpIssueDetails());
		}
		return itemMasterRepo.save(itemAdd);
	}

	public List<ItemMaster> getAllItems() {
		// TODO Auto-generated method stub
		return itemMasterRepo.findAll();
	}

	public String deleteItemById(String id) {
		// TODO Auto-generated method stub
		itemMasterRepo.deleteById(id);
		return "Sucessfully Deleted Item of ID : "+id;
	}

	public ItemMaster getItemById(String id) {
		
		ItemMaster item = null;
		Optional<ItemMaster> op = itemMasterRepo.findById(id);
		if(op.isPresent())
			item = op.get();
		return item;
		
	}

}
