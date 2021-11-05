package com.codetest.survivor1.service;

import org.springframework.stereotype.Service;

import com.codetest.survivor1.dao.SurvivorDAO;
import com.codetest.survivor1.exceptions.SurvivorException;

@Service
public class ReportServiceImpl implements ReportService {

	private final SurvivorDAO survivorDAO;

	public ReportServiceImpl(SurvivorDAO survivorDAO) {
		super();
		this.survivorDAO = survivorDAO;
	}

	@Override
	public float percentInfectedSurvivor() {
		if (!survivorDAO.findAll().isEmpty()) {
			float percentInfectedSurvivor = (float) survivorDAO.findByInfectedFlagTrue().size()
					/ survivorDAO.findAll().size() * 100;
			int percentInfectedSurvivorReady = (int) percentInfectedSurvivor;
			return percentInfectedSurvivorReady;
		} else {
			throw new SurvivorException("There's no survivor registered");
		}
	}

	@Override
	public float percentNotInfectedSurvivor() {
		if (!survivorDAO.findAll().isEmpty()) {
			float percentNotInfectedSurvivor = (float) survivorDAO.findByInfectedFlagFalse().size()
					/ survivorDAO.findAll().size() * 100;
			int percentNotInfectedSurvivorReady = (int) percentNotInfectedSurvivor;
			return percentNotInfectedSurvivorReady;
		} else {
			throw new SurvivorException("There's no survivor registered");
		}
	}

}
