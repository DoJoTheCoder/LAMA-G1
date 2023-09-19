package com.lama_b4_g1.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lama_b4_g1.backend.models.ItemMaster;

public interface ItemMasterRepository extends JpaRepository<ItemMaster, String>{
	@Query("SELECT DISTINCT im.itemCategory FROM ItemMaster im")
	public List<String> findDistinctByItemCategories();
	
	@Query ("SELECT DISTINCT im.itemMake FROM ItemMaster im WHERE im.itemCategory=?1")
	public List<String> findDistinctByItemMakes(String itemCategory);
	
	@Query("SELECT im.itemDescription FROM ItemMaster im WHERE im.itemCategory=?1 AND im.itemMake=?2 ")
	public List<String> findItemDescriptions(String itemCategory, String itemMake);
	
	@Query("SELECT im.itemValuation FROM ItemMaster im WHERE im.itemDescription=?1")
	public String findItemValue(String itemDescription);
	
	public ItemMaster findByItemDescription(String itemDescription);
		
}
