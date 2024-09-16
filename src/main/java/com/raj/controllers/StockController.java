package com.raj.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.dtos.StockSummaryDTO;
import com.raj.service.StockService;

@RestController
@RequestMapping("/api/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	// API endpoint to get stock for an item
	@GetMapping("/{itemId}")
	public ResponseEntity<HashMap<String, Integer>> getStockForItem(@PathVariable Long itemId) {
		Integer stockForItem = stockService.getStockForItem(itemId);
		HashMap<String, Integer> res = new HashMap<>();
		res.put("availableQuantity", stockForItem);
		return ResponseEntity.ok(res);
	}

	@GetMapping("/all")
	public ResponseEntity<List<StockSummaryDTO>> getAllItemsStock() {
		return ResponseEntity.ok(stockService.getAllItemsStock());
	}
}
