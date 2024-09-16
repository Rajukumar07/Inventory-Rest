package com.raj.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raj.dtos.StockSummaryDTO;
import com.raj.entity.Item;
import com.raj.repository.ItemRepository;
import com.raj.repository.PurchaseDetailsRepository;
import com.raj.repository.SaleDetailRepository;
import com.raj.service.StockService;

@Service
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	private PurchaseDetailsRepository purchaseDetailsRepository;

	@Autowired
	private SaleDetailRepository saleDetailRepository;

	@Autowired
	private ItemRepository itemRepository;

	// Method to calculate stock for a specific item
	public Integer getStockForItem(Long itemId) {
		Integer purchasedQuantity = purchaseDetailsRepository.getTotalPurchasedQuantity(itemId);
		Integer soldQuantity = saleDetailRepository.getTotalSoldQuantity(itemId);

		// If there are no purchases or sales, set default to 0
		purchasedQuantity = (purchasedQuantity != null) ? purchasedQuantity : 0;
		soldQuantity = (soldQuantity != null) ? soldQuantity : 0;

		// Stock = purchased - sold
		return purchasedQuantity - soldQuantity;
	}

	
	
	// Method to calculate stock for all items
	public List<StockSummaryDTO> getAllItemsStock() {
		List<Item> items = itemRepository.findAll();

		return items.stream().map(item -> {
			Integer purchasedQuantity = purchaseDetailsRepository.getTotalPurchasedQuantity(item.getId());
			Integer soldQuantity = saleDetailRepository.getTotalSoldQuantity(item.getId());

			purchasedQuantity = (purchasedQuantity != null) ? purchasedQuantity : 0;
			soldQuantity = (soldQuantity != null) ? soldQuantity : 0;

			Integer availableStock = purchasedQuantity - soldQuantity;

			return new StockSummaryDTO(item.getId(), item.getItemName(), purchasedQuantity, soldQuantity, availableStock);
		}).collect(Collectors.toList());
	}

}
