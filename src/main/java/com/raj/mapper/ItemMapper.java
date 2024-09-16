package com.raj.mapper;

import com.raj.dtos.ItemDto;
import com.raj.entity.Item;

public class ItemMapper {

	public static ItemDto mapToItemDto(Item item) {
		return new ItemDto(item.getId(), item.getItemName());
	}

	public static Item mapToItem(ItemDto itemDto) {
		return new Item(itemDto.getId(), itemDto.getItemName());
	}
}
