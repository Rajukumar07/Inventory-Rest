package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
