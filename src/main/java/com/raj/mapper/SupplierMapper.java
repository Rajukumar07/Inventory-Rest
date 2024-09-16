package com.raj.mapper;

import com.raj.dtos.SupplierDto;
import com.raj.entity.Supplier;

public class SupplierMapper {

	public static SupplierDto mapToSupplierDto(Supplier supplier) {
		return new SupplierDto(supplier.getId(), supplier.getSupplierName(),
				supplier.getMobile(), supplier.getContactPersonName());
	}

	public static Supplier mapToSupplier(SupplierDto dto) {
		return new Supplier(dto.getId(), dto.getSupplierName(), 
				dto.getMobile(),dto.getContactPersonName());
	}
}
