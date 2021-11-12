package com.example.expose;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import com.example.expose.dtos.SimulationDto;

@SpringBootApplication
@EnableCaching
public class ExposeApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ExposeApplication.class, args);
	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	RedisTemplate<String, SimulationDto> redisTemplate() {
		RedisTemplate<String, SimulationDto> redisTemplate = new RedisTemplate<String, SimulationDto>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}

}
