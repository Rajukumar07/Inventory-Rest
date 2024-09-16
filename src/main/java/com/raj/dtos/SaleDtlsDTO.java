package com.raj.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDtlsDTO {
	private Long id;

	private ItemDto item;
	private Integer qty;
	private Double rate;
	private Double totalAmount;
	private SaleMstrDTO saleMstrDTO;
}
