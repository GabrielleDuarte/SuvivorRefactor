package com.codetest.survivor1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.survivor1.service.ReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/apireport")
@Api(value = "API REST Reports")
public class ReportController {

	private ReportService reportService;
	
	public ReportController(ReportService reportService) {
		super();
		this.reportService = reportService;
	}

	@GetMapping(value = "/percentinfectedsurvivor")
	@ApiOperation(value = "Returns the percent of the infected survivors")
	public ResponseEntity<Float> percentInfectedSurvivorShow(){
		return new ResponseEntity<>(reportService.percentInfectedSurvivor(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/percentnoinfectedsurvivor")
	@ApiOperation(value = "Returns the percent of the health survivors")
	public ResponseEntity<Float> percentNotInfectedSurvivorShow(){
		return new ResponseEntity<>(reportService.percentNotInfectedSurvivor() , HttpStatus.OK);
	}
}
