package com.raj.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SaleMstrDTO {

	private Long id;
	private String customerName;
	private String customerContact;
	private Integer billNo;
	private LocalDateTime dateTime;
	private Double totalAmount;
    private List<SaleDtlsDTO> saleDtls;
}
