package com.raj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raj.entity.PurchaseDetails;

public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Long> {

//	@Query(value = "select new StockItemDto(pd.item.id, im.itemName) " +
//            "from PurchaseDetails pd " +
//            "join Item im on pd.item.id = im.id " +
//            "group by pd.item.id, im.itemName")
//    List<StockItemDto> getStockGoods();

	@Query(value = "select pd.item_id, im.item_name  " + "from purchase_details pd "
			+ "join item_master im on pd.item_id = im.id "
			+ "group by pd.item_id, im.item_name", nativeQuery = true)
	List<Object[]> getStockGoods();

	@Query(value="SELECT DISTINCT pd.price FROM purchase_details pd WHERE pd.item_id = :itemId",nativeQuery=true)
	List<Double> findDistinctPricesByItemId(@Param("itemId") Long itemId);
	
	
	// Query to calculate total purchased quantity for an item
    @Query("SELECT SUM(pd.quantity) FROM PurchaseDetails pd WHERE pd.item.id = :itemId")
    Integer getTotalPurchasedQuantity(@Param("itemId") Long itemId);

}
