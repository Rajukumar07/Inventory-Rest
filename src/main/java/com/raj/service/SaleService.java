package com.raj.service;

import java.util.List;

import com.raj.dtos.SaleMstrDTO;
import com.raj.entity.SaleMaster;

public interface SaleService {
	List<SaleMaster> getAllSale();
	SaleMaster saveSale(SaleMstrDTO entity);
}
