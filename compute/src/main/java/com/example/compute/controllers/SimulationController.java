package com.example.compute.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.compute.dtos.SimulationDto;
import com.example.compute.services.SimulationService;

@RestController
@RequestMapping("/simulate")
public class SimulationController {

	private final SimulationService simulationService;

	public SimulationController(SimulationService simulationService) {
		super();
		this.simulationService = simulationService;
	}
	
	@PostMapping("/compute")
	public SimulationDto getSimulation(@RequestBody SimulationDto dto) {
		return simulationService.getSimulation(dto);
	}
}
