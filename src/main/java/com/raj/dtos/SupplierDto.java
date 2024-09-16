package com.raj.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {

	private Long id;
	private String supplierName;	
	private Long mobile;
	private String contactPersonName;
	

}
