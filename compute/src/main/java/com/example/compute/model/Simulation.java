package com.example.compute.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Simulation {

	@Id
	@GeneratedValue
	private Long id;
	
	private Integer period;

	private Integer amount;
	
	private float interest;
	
	private float monthlyPayment;

	public Simulation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Simulation(Long id, Integer period, Integer amount, float interest, float monthlyPayment) {
		super();
		this.id = id;
		this.period = period;
		this.amount = amount;
		this.interest = interest;
		this.monthlyPayment = monthlyPayment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public float getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(float monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	
	
	
	
	
}
