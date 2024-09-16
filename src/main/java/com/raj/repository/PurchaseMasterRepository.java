package com.raj.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.PurchaseMaster;


public interface PurchaseMasterRepository extends JpaRepository<PurchaseMaster, Long> {
	
}
