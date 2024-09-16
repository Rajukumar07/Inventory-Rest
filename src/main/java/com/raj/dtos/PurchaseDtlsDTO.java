package com.raj.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PurchaseDtlsDTO {
	private Long id;	
    private ItemDto itemDto;
	private Integer quantity;
	private Double price;
	private Double totalAmount;	
    private PurchaseMstrDTO purchaseMasteDto;
}
