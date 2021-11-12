package com.example.expose.push_notif_utils;

import org.springframework.stereotype.Controller;

import com.example.expose.controllers.SimulationController;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class SimulateWSController implements Observer<SimulationController> {
	private final SimpMessagingTemplate simpMessagingTemplate;

	SimulationController simulationController;

	public SimulateWSController(SimpMessagingTemplate simpMessagingTemplate,
			SimulationController simulationController) {
		this.simpMessagingTemplate = simpMessagingTemplate;
		this.simulationController = simulationController;
		this.simulationController.subscribe(this);
	};

	public void handle(PropertyChangedEventArgs<SimulationController> args) {
		System.out.println("SimulateWSController:hundle");
		this.simpMessagingTemplate.convertAndSend("/queue/new-cashed-values", args.dto);
	}
}
