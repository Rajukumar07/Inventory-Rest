package com.raj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.dtos.PurchaseDtlsDTO;
import com.raj.dtos.PurchaseMstrDTO;
import com.raj.dtos.StockItemDto;
import com.raj.entity.Item;
import com.raj.entity.PurchaseDetails;
import com.raj.entity.PurchaseMaster;
import com.raj.entity.Supplier;
import com.raj.repository.PurchaseDetailsRepository;
import com.raj.repository.PurchaseMasterRepository;
import com.raj.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseMasterRepository purchaseMasterRepository;
	@Autowired
	private PurchaseDetailsRepository detailsRepository;

	@Override
	public List<PurchaseMaster> getAllPurchases() {
		return purchaseMasterRepository.findAll();
	}

	@Override
	public PurchaseMaster savePurchase(PurchaseMstrDTO dto) {
		// Your logic for saving purchase
		PurchaseMaster entity = new PurchaseMaster();
		BeanUtils.copyProperties(dto, entity);

		Supplier sup = new Supplier();
		sup.setId(dto.getSupplierId());
		entity.setSupplier(sup);

		PurchaseMaster save = purchaseMasterRepository.save(entity);
		List<PurchaseDtlsDTO> details = dto.getPurchaseDtls();
		List<PurchaseDetails> purchaseDetails = new ArrayList<>();
		for (PurchaseDtlsDTO dtlsDTO : details) {
			Item item = new Item();
			PurchaseDetails pd = new PurchaseDetails();
			BeanUtils.copyProperties(dtlsDTO, pd);
			item.setId(dtlsDTO.getItemDto().getId());
			pd.setItem(item);
			pd.setPurchaseMaster(save);
			// purchaseDetails entity adding into list
			purchaseDetails.add(pd);

		}
		detailsRepository.saveAll(purchaseDetails);
		return save;

	}

	@Override
	public List<StockItemDto> getStockGoods() {
		List<Object[]> stockGoods = detailsRepository.getStockGoods();
		return stockGoods.stream().map(result -> new StockItemDto((long) result[0], (String) result[1]))
				.collect(Collectors.toList());

	}

	@Override
	public List<Double> getItemPrice(Long id) {
		return detailsRepository.findDistinctPricesByItemId(id);
	}
}