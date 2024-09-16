package com.raj.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.dtos.SupplierDto;
import com.raj.entity.Supplier;
import com.raj.exceptions.ResourceNotFoundException;
import com.raj.mapper.SupplierMapper;
import com.raj.repository.SupplierRepository;
import com.raj.service.SupplierService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public SupplierDto createSupplier(SupplierDto supplierDto) {
		Supplier supplier = SupplierMapper.mapToSupplier(supplierDto);
		Supplier savedsupplier = supplierRepository.save(supplier);
		return SupplierMapper.mapToSupplierDto(savedsupplier);
	}

	@Override
	public SupplierDto getSupplierById(Long supplierId) {
		Supplier supplier = supplierRepository.findById(supplierId).orElseThrow(
				() -> new ResourceNotFoundException("Supplier is not exist with given id : " + supplierId));
		return SupplierMapper.mapToSupplierDto(supplier);
	}

	@Override
	public List<SupplierDto> getAllSupplier() {
		List<Supplier> suppliers = supplierRepository.findAll();
		return suppliers.stream().map((supplier) -> SupplierMapper.mapToSupplierDto(supplier))
				.collect(Collectors.toList());
	}

	@Override
	public SupplierDto updateSupplier(Long supplierId, SupplierDto dto) {
		Supplier supplier = supplierRepository.findById(supplierId)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier is not exists with given id:" + supplierId));
		supplier.setSupplierName(dto.getSupplierName());		
		supplier.setMobile(dto.getMobile());
		supplier.setContactPersonName(dto.getContactPersonName());

		Supplier updateSupplierObj = supplierRepository.save(supplier);
		return SupplierMapper.mapToSupplierDto(updateSupplierObj);
	}

	@Override
	public void deleteSupplier(Long supplierId) {
		supplierRepository.findById(supplierId)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier is not exists with given id:" + supplierId));
		supplierRepository.deleteById(supplierId);
	}

}
