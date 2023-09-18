package com.lama_b4_g1.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lama_b4_g1.backend.models.ItemMaster;

public interface ItemMasterRepository extends JpaRepository<ItemMaster, String>{
	@Query("SELECT DISTINCT im.itemCategory FROM ItemMaster im")
	public List<String> findDistinctByItemCategories();
		
}
