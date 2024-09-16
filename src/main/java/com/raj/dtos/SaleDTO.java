package com.raj.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDTO {
	private Long itemId;
	private Integer quantity;
	private Double price;
	private String customerName;
	private String customerContact;

	// Constructor, Getters, Setters
}
