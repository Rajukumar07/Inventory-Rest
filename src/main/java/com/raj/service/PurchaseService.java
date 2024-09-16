package com.raj.service;

import java.util.List;

import com.raj.dtos.PurchaseMstrDTO;
import com.raj.dtos.StockItemDto;
import com.raj.entity.PurchaseMaster;

//PurchaseService.java
public interface PurchaseService {
	List<PurchaseMaster> getAllPurchases();

	PurchaseMaster savePurchase(PurchaseMstrDTO purchaseMaster);

	public List<StockItemDto> getStockGoods();
	
	public List<Double>getItemPrice(Long id);
}
