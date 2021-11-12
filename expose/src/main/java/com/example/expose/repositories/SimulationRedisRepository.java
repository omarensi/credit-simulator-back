package com.example.expose.repositories;

import java.util.Map;

import com.example.expose.dtos.SimulationDto;

public interface SimulationRedisRepository {

	void save(SimulationDto dto);
    Map<String, SimulationDto> findAll();
}
