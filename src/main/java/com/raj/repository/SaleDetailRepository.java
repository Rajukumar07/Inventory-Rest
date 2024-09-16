package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raj.entity.SaleDetail;

public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long>{
	
	// Query to calculate total sold quantity for an item
    @Query("SELECT SUM(sd.quantity) FROM SaleDetail sd WHERE sd.item.id = :itemId")
    Integer getTotalSoldQuantity(@Param("itemId") Long itemId);

}
