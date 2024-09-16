package com.raj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.dtos.ItemDto;
import com.raj.service.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	//Build Add Item REST API
	@PostMapping("/create")
	public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto){
		ItemDto savedItem = itemService.createItem(itemDto);
		return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
		
	}
// Build Get Item Rest API
	@GetMapping("/{id}")
	public ResponseEntity<ItemDto> getItemById(@PathVariable("id") Long itemId){
		ItemDto itemDto = itemService.getItemById(itemId);
		return ResponseEntity.ok(itemDto);
		
	}
	
	// Build Get All Item rest API
	@GetMapping("/allItem")
	public ResponseEntity<List<ItemDto>> getAllItem(){
		 List<ItemDto> item = itemService.getAllItem();
		 return ResponseEntity.ok(item);
	}
	
	//Build update Item rest API
	@PostMapping("/update/{id}")
	public ResponseEntity<ItemDto> updateItem(@PathVariable("id") Long itemId,
			@RequestBody ItemDto updateItem){
		ItemDto itemDto = itemService.updateItem(itemId, updateItem);
		return ResponseEntity.ok(itemDto);
	}
	
	//Build delete Item rest API
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable("id") Long itemId){
		itemService.deleteItem(itemId);
		return ResponseEntity.ok("item deleted successfully!");
	}
}
