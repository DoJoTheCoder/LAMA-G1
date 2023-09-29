package com.lama_b4_g1.backend.services;

import java.util.List;

import com.lama_b4_g1.backend.models.ItemMaster;

public interface ItemMasterService {

		
		
		public List<String> getAllItemCategory();
		
		public List<String> getItemMakes(String itemCategory);
		
		public List<String> getItemDescriptions(String itemCategory, String itemMake);
		
		public String getItemValue(String itemDesc);

		public ItemMaster addItemMaster(ItemMaster itemAdd);

		public List<ItemMaster> getAllItems();
		
		public String deleteItemById(String id);
		
		public ItemMaster getItemById(String id);
}
