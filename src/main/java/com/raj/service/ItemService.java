package com.raj.service;

import java.util.List;

import com.raj.dtos.ItemDto;

public interface ItemService {

	ItemDto createItem(ItemDto itemDto);

	ItemDto getItemById(Long itemId);

	List<ItemDto> getAllItem();

	ItemDto updateItem(Long itemId, ItemDto itemDto);

	void deleteItem(Long itemId);

}
