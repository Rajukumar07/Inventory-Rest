package com.raj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.dtos.PurchaseDtlsDTO;
import com.raj.dtos.PurchaseMstrDTO;
import com.raj.dtos.StockItemDto;
import com.raj.entity.PurchaseMaster;
import com.raj.service.PurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@PostMapping(value = "/doPurchase")
	public ResponseEntity<PurchaseMaster> createPurchase(@RequestBody PurchaseMstrDTO obj) {

		List<PurchaseDtlsDTO> purchaseDtlsDTO = obj.getPurchaseDtls();
		for (PurchaseDtlsDTO details : purchaseDtlsDTO) {
			System.out.println("Item => "+details.getItemDto());
		}
		PurchaseMaster savedPurchase = purchaseService.savePurchase(obj);
		return ResponseEntity.ok(savedPurchase);
	}

	@GetMapping("/allPurchase")
	public ResponseEntity<List<PurchaseMaster>> getAllPurchases() {
		List<PurchaseMaster> purchases = purchaseService.getAllPurchases();
//		for (PurchaseMaster purchase : purchases) {
//			System.out.println("Supplier ID: " + purchase.getSupplier().getId());
//			System.out.println("Supplier Name: " + purchase.getSupplier().getSupplierName());
//		}
		return ResponseEntity.ok(purchases);
	}

	@GetMapping("/getStock")
	public ResponseEntity<List<StockItemDto>> getStockGoods() {
		 List<StockItemDto> stockGoods = purchaseService.getStockGoods();
		return ResponseEntity.ok(stockGoods);
	}
	
	@GetMapping("/getItemPrice/{id}")
	public ResponseEntity<List<Double>> getGoodsPrice(@PathVariable("id") Long itemId) {
		 List<Double> stockGoods = purchaseService.getItemPrice(itemId);
		return ResponseEntity.ok(stockGoods);
	}

}
