package com.codetest.survivor1.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.survivor1.VO.SurvivorVO;
import com.codetest.survivor1.entity.ItemInventory;
import com.codetest.survivor1.entity.Location;
import com.codetest.survivor1.entity.Survivor;
import com.codetest.survivor1.service.SurvivorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/apisurvivor")
@Api(value = "API REST Survivor")
public class SurvivorController {

	private SurvivorService survivorService;

	private ModelMapper modelMapper;


	public SurvivorController(SurvivorService survivorService, ModelMapper modelMapper) {
		super();
		this.survivorService = survivorService;
		this.modelMapper = modelMapper;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value = "/add")
	@ApiOperation(value = "Add a survivor")
	public void survivorAdd(@RequestBody SurvivorVO survivor) {
		survivorService.addSurvivor(modelMapper.map(survivor, Survivor.class));
	}

	@PutMapping(value = "/updatelastlocation/{id}")
	@ApiOperation(value = "Update the last location of a survivor")
	public ResponseEntity<Void> survivorUpdateLocation(@ModelAttribute Location lastLocation, @PathVariable Long id) {
		survivorService.updateLastLocation(lastLocation, id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@GetMapping("/warninfected/{id}")
	@ApiOperation(value = "Warn an Infected Survivor")
	public ResponseEntity<Void> survivorUpdateLocation(@PathVariable Long id) {
		survivorService.warnInfectedSurvivor(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PutMapping("/trade/survivor")
	@ApiOperation(value = "Make the trade")
	public ResponseEntity<Void> trading(@RequestParam List<String> idSurvivors, @RequestParam List<String> idsItemInventory){
		List<Long> idS = new ArrayList<Long>();
		for (String string : idSurvivors) {
			idS.add(Long.valueOf(string));
		}
		
		List<Long> idII = new ArrayList<Long>();
		for (String string : idsItemInventory) {
			idII.add(Long.valueOf(string));
		}
		survivorService.trade(idS.get(0), idS.get(1), idII.get(0), idII.get(1));
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
