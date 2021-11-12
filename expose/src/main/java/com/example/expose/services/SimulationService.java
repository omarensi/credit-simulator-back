package com.example.expose.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.expose.dtos.SimulationDto;
import com.example.expose.repositories.SimulationRedisRepoImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class SimulationService {
	
		private final WebClient webClient;

		private final String url = "http://localhost:8081";
		
		private final SimulationRedisRepoImpl redisRepoImpl;

		public SimulationService(WebClient.Builder webClientBuilder, SimulationRedisRepoImpl redisRepoImpl ) {
			super();
			this.webClient = webClientBuilder.baseUrl(url).build();
			this.redisRepoImpl = redisRepoImpl;

		}
		
		public Mono<SimulationDto> calculateSimulation(SimulationDto dto) {
			SimulationDto dtoOpt = redisRepoImpl.findById(dto);
			if (dtoOpt != null) {
				dtoOpt.setFromCach(true);
			} else {
				dtoOpt = webClient.post()
				        .uri("/simulate/compute")
				        .body(Mono.just(dto), SimulationDto.class)
				        .retrieve()
				        .bodyToMono(SimulationDto.class).block();
				redisRepoImpl.save(dtoOpt);
				
			}
			
			return Mono.just(dtoOpt);

		}

		public Map<String, SimulationDto> getAllFromCash() {
			// TODO Auto-generated method stub
			return redisRepoImpl.findAll();
		}

		
		
		
}
