package com.lama_b4_g1.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama_b4_g1.backend.models.ItemMaster;
import com.lama_b4_g1.backend.repository.ItemMasterRepository;

@Service
public class ItemMasterService {

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
			ItemMaster obj = itemMasterRepo.save(itemAdd);
			return obj;
		}
}
