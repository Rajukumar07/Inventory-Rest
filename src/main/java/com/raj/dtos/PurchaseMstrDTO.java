package com.raj.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseMstrDTO {
	
	private String invoiceNo;
	private LocalDate invoiceDate;	
    private Long supplierId;
    private Double totalAmount;
    private List<PurchaseDtlsDTO> purchaseDtls;
}
