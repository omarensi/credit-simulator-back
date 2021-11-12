package com.example.expose.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expose.dtos.SimulationDto;
import com.example.expose.push_notif_utils.Observable;
import com.example.expose.services.SimulationService;

@RestController
@RequestMapping("/simulate")
@CrossOrigin(origins = "*")
public class SimulationController  extends Observable<SimulationController> {

	
	private final SimulationService simulationService;

	public SimulationController(SimulationService simulationService) {
		super();
		this.simulationService = simulationService;
	}
	
	@PostMapping
	public SimulationDto simulate(@RequestBody SimulationDto dto) {
		SimulationDto s = simulationService.calculateSimulation(dto).block();
		if (!s.isFromCach()) {
			notifyObservers(this, s);
		}
		
		return s;
				
	}
	
	@GetMapping("/all-cashed-simulations")
	public Map<String, SimulationDto> getAllFromCash() {
		return simulationService.getAllFromCash();
				
	}
	
	
}
