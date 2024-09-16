package com.raj.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.dtos.ItemDto;
import com.raj.entity.Item;
import com.raj.exceptions.ResourceNotFoundException;
import com.raj.mapper.ItemMapper;
import com.raj.repository.ItemRepository;
import com.raj.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public ItemDto createItem(ItemDto itemDto) {
		Item item = ItemMapper.mapToItem(itemDto);
		Item saveditem = itemRepository.save(item);
		return ItemMapper.mapToItemDto(saveditem);
	}

	@Override
	public ItemDto getItemById(Long itemId) {
		Item item = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item is not exist with given id : " + itemId));
		return ItemMapper.mapToItemDto(item);
	}

	@Override
	public List<ItemDto> getAllItem() {
		List<Item> items = itemRepository.findAll();
		return items.stream().map((item) -> ItemMapper.mapToItemDto(item)).collect(Collectors.toList());
	}

	@Override
	public ItemDto updateItem(Long itemId, ItemDto updatedItem) {
		Item item = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item is not exists with given id:" + itemId));

		item.setItemName(updatedItem.getItemName());
//		item.setItemPrice(updatedItem.getItemPrice());
		Item updateItemObj = itemRepository.save(item);

		return ItemMapper.mapToItemDto(updateItemObj);
	}

	@Override
	public void deleteItem(Long itemId) {
		itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item is not exists with given id:" + itemId));
		itemRepository.deleteById(itemId);

	}

}
