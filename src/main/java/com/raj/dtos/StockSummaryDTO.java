package com.raj.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockSummaryDTO {
	private Long itemId;
	private String itemName;
	private Integer totalPurchased;
	private Integer totalSold;
	private Integer availableStock;

	public StockSummaryDTO(Long itemId, String itemName, Integer totalPurchased, Integer totalSold,
			Integer availableStock) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.totalPurchased = totalPurchased;
		this.totalSold = totalSold;
		this.availableStock = availableStock;
	}

	// Getters and Setters
}