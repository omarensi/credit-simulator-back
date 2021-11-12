package com.example.compute.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.compute.dtos.SimulationDto;
import com.example.compute.model.Simulation;
import com.example.compute.repositories.SimulationRepository;



@Service
public class SimulationService {

		private final SimulationRepository simulationRepository;
		
		private final ModelMapper mapper;

		public SimulationService(SimulationRepository simulationRepository, ModelMapper mapper) {
			super();
			this.simulationRepository = simulationRepository;
			this.mapper = mapper;
		}
		
		public SimulationDto getSimulation(SimulationDto dto) {
			
			List<Simulation> simulationList = simulationRepository.findByPeriodAndAmountAndInterest(dto.getPeriod(), dto.getAmount(), dto.getInterest());
			if (simulationList.size() > 0) {
				return mapper.map(simulationList.get(0), SimulationDto.class);
			} else {
				dto = compute(dto);
				simulationRepository.save(mapper.map(dto, Simulation.class));
				return dto;
			}
			
		}

		private SimulationDto compute(SimulationDto dto) {
			float backAmount = dto.getAmount() + dto.getAmount() * dto.getInterest() * dto.getPeriod() / 100;
			dto.setMonthlyPayment(backAmount/(dto.getPeriod() * 12));
			return dto;
		}
		
		
}
