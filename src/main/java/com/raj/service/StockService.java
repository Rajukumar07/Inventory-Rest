package com.raj.service;

import java.util.List;

import com.raj.dtos.StockSummaryDTO;

public interface StockService {
	public Integer getStockForItem(Long itemId);

	public List<StockSummaryDTO> getAllItemsStock();
}
