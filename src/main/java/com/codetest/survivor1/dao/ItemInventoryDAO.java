package com.codetest.survivor1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.survivor1.entity.ItemInventory;

public interface ItemInventoryDAO extends JpaRepository<ItemInventory, Long> {

}
