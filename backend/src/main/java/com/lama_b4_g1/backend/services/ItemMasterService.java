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
		
}
