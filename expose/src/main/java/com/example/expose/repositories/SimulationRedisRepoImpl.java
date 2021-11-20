package com.example.expose.repositories;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.expose.dtos.SimulationDto;

@Repository
public class SimulationRedisRepoImpl  {

	private RedisTemplate<String, SimulationDto> redisTemplate;

    private HashOperations hashOperations;
    
    public SimulationRedisRepoImpl(RedisTemplate<String, SimulationDto> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }
    
    
    public void save(SimulationDto dto) {
        hashOperations.put("CreditParams", getId(dto) ,dto);
    }

    
    private String getId(SimulationDto dto) {
    	System.out.println(dto.getAmount());
    	System.out.println(dto.getPeriod());
    	System.out.println(dto.getInterest());
		return dto.getAmount().toString() + "-" + dto.getPeriod().toString() + "-" + dto.getInterest();
	}


	public Map<String, SimulationDto> findAll() {
        return hashOperations.entries("CreditParams");
    }
	
	
    public SimulationDto findById(SimulationDto dto) {
        return (SimulationDto)hashOperations.get("CreditParams",  getId(dto));
    }
}
