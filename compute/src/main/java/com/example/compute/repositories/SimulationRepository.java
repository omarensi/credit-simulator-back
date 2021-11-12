package com.example.compute.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.compute.model.Simulation;


@Repository
public interface SimulationRepository extends JpaRepository<Simulation, Long> {

	List<Simulation> findByPeriodAndAmountAndInterest(Integer period, Integer amount, float interest);
}
