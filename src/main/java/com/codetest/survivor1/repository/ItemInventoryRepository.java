package com.codetest.survivor1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.survivor1.entity.ItemInventory;

public interface ItemInventoryRepository extends JpaRepository<ItemInventory, Long> {

}
