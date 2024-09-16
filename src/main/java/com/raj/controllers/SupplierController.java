package com.raj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.dtos.SupplierDto;
import com.raj.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	// Build Add Supplier REST API
	@PostMapping("/create")
	public ResponseEntity<SupplierDto> createSupplier(@RequestBody SupplierDto supplierDto) {
		SupplierDto savedSupplier = supplierService.createSupplier(supplierDto);
		return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
	}

	// Build Get Supplier Rest API
	@GetMapping("/{id}")
	public ResponseEntity<SupplierDto> getSupplierById(@PathVariable("id") Long supplierId) {
		SupplierDto supplierDto = supplierService.getSupplierById(supplierId);
		return ResponseEntity.ok(supplierDto);
	}

	// Build Get All Supplier rest API
	@GetMapping("/getAll")
	public ResponseEntity<List<SupplierDto>> getAllSupplier() {
		List<SupplierDto> supplierDtos = supplierService.getAllSupplier();
		return ResponseEntity.ok(supplierDtos);
	}

	// Build update Supplier rest API
	@PostMapping("/update/{id}")
	public ResponseEntity<SupplierDto> updateSupplier(@PathVariable("id") Long SupplierId,
			@RequestBody SupplierDto dto) {
		SupplierDto supplierDto = supplierService.updateSupplier(SupplierId, dto);
		return ResponseEntity.ok(supplierDto);
	}

	// Build delete Item rest API
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteSupplier(@PathVariable("id") Long supplierId) {
		supplierService.deleteSupplier(supplierId);
		return ResponseEntity.ok("Supplier deleted succeessfully");
	}

}
