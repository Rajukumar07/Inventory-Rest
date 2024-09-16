package com.raj.service;

import java.util.List;

import com.raj.dtos.SupplierDto;

public interface SupplierService {

	SupplierDto createSupplier(SupplierDto supplierDto);
	
	SupplierDto getSupplierById(Long supplierId);
	
	List<SupplierDto> getAllSupplier();
	
	SupplierDto updateSupplier(Long supplierId,SupplierDto supplierDto);
	
	void deleteSupplier(Long supplierId);
}
