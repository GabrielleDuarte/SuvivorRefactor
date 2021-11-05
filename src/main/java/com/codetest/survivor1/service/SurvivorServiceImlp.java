package com.codetest.survivor1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetest.survivor1.repository.ItemInventoryRepository;
import com.codetest.survivor1.repository.SurvivorRepository;
import com.codetest.survivor1.entity.ItemInventory;
import com.codetest.survivor1.entity.Location;
import com.codetest.survivor1.entity.Survivor;
import com.codetest.survivor1.exceptions.ItemInventoryException;
import com.codetest.survivor1.exceptions.SurvivorException;

@Service
public class SurvivorServiceImlp implements SurvivorService {

	private SurvivorRepository survivorDAO;
	@Autowired
	private ItemInventoryRepository itemInventoryRepository;

	public SurvivorServiceImlp(SurvivorRepository survivorDAO) {
		super();
		this.survivorDAO = survivorDAO;
	}

	@Override
	public void addSurvivor(Survivor survivor) {
		survivorDAO.save(survivor);
	}

	@Override
	public void warnInfectedSurvivor(Long id) {
		Survivor survivor = survivorDAO.findById(id)
				.orElseThrow(() -> new SurvivorException("This survivor is not registered"));

		survivor.warnedInfection();
		survivor.testInfected();
		survivorDAO.save(survivor);
	}

	@Override
	public void updateLastLocation(Location newLastLocation, Long id) {
		Survivor survivor = survivorDAO.findById(id)
				.orElseThrow(() -> new SurvivorException("This survivor is not registered"));
		survivor.setLastLocation(newLastLocation);
		survivorDAO.save(survivor);

	}

	@Override
	public void trade(Long id1, Long id2, Long id3, Long id4) {
		Survivor survivor1 = survivorDAO.findById(id1)
				.orElseThrow(() -> new SurvivorException("This survivor is not registered"));

		Survivor survivor2 = survivorDAO.findById(id2)
				.orElseThrow(() -> new SurvivorException("This survivor is not registered"));

		ItemInventory offer = itemInventoryRepository.findById(id3)
				.orElseThrow(() -> new ItemInventoryException("This survivor is not registered"));
		
		ItemInventory wanted = itemInventoryRepository.findById(id4)
				.orElseThrow(() -> new ItemInventoryException("This survivor is not registered"));

		if (survivor1.getInfectedFlag() == true && survivor1.getInfectedFlag() == true) {
			if (survivor1.getInventory().getItens().contains(offer)
					&& survivor2.getInventory().getItens().contains(wanted)) {
				if (offer.getQuantity() * offer.getItem().getPoints() == wanted.getQuantity()
						* wanted.getItem().getPoints()) {
					survivor1.getInventory().getItens().remove(offer);
					survivor1.getInventory().getItens().add(wanted);
					survivor2.getInventory().getItens().remove(wanted);
					survivor1.getInventory().getItens().add(offer);
					survivorDAO.save(survivor1);
					survivorDAO.save(survivor2);
				}
			}
		} 
	}

}
