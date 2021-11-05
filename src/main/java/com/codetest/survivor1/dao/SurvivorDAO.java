package com.codetest.survivor1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.survivor1.entity.Survivor;

public interface SurvivorDAO extends JpaRepository<Survivor, Long> {
	
	public List<Survivor> findByInfectedFlagTrue();
	
	public List<Survivor> findByInfectedFlagFalse();
	
}
