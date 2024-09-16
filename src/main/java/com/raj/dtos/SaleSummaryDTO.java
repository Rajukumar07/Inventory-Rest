package com.raj.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleSummaryDTO {
	private Long itemId;
	private String itemName;
	private Integer totalSold;
	private Double totalRevenue;

	public SaleSummaryDTO(Long itemId, String itemName, Integer totalSold, Double totalRevenue) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.totalSold = totalSold;
		this.totalRevenue = totalRevenue;
	}

	// Getters and Setters
}
