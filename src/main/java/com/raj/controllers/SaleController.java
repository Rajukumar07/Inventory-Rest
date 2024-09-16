package com.raj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.dtos.SaleMstrDTO;
import com.raj.entity.SaleMaster;
import com.raj.service.SaleService;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
	@Autowired
	private SaleService saleService;

	@PostMapping("/doSale")
	public ResponseEntity<SaleMaster> createSale(@RequestBody SaleMstrDTO saleMaster) {
		System.out.println();
		
		SaleMaster saveSale = saleService.saveSale(saleMaster);
		return ResponseEntity.ok(saveSale);
	}

	@GetMapping("/allSale")
	public ResponseEntity<List<SaleMaster>> getAllSale() {
		List<SaleMaster> sales = saleService.getAllSale();
		for (SaleMaster sale : sales) {
			System.out.println("Customer Name : " + sale.getCustomerName());
			System.out.println("Customer Contact: " + sale.getCustomerContact());
		}
		return ResponseEntity.ok(sales);
	}

}
