package com.raj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.dtos.SaleDtlsDTO;
import com.raj.dtos.SaleMstrDTO;
import com.raj.entity.Item;
import com.raj.entity.SaleDetail;
import com.raj.entity.SaleMaster;
import com.raj.repository.SaleDetailRepository;
import com.raj.repository.SaleMasterRepository;
import com.raj.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleMasterRepository masterRepository;
	@Autowired
	private SaleDetailRepository detailRepository;

	@Override
	public List<SaleMaster> getAllSale() {

		return masterRepository.findAll();
	}

	@Override
	public SaleMaster saveSale(SaleMstrDTO dto) {
		SaleMaster entity = new SaleMaster();
		BeanUtils.copyProperties(dto, entity);
		SaleMaster save = masterRepository.save(entity);

		List<SaleDtlsDTO> saleDtlsDTO = dto.getSaleDtls();
		List<SaleDetail> saleDetails = new ArrayList<>();
		for (SaleDtlsDTO dtlsDTO : saleDtlsDTO) {
			Item item = new Item();
			SaleDetail detail = new SaleDetail();
			BeanUtils.copyProperties(dtlsDTO, detail);
			item.setId(dtlsDTO.getItem().getId());
			detail.setItem(item);
			detail.setSaleMaster(save);
			saleDetails.add(detail);
		}
		detailRepository.saveAll(saleDetails);

		return save;
	}

}
