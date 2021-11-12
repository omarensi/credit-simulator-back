package com.example.expose.dtos;

import java.io.Serializable;

public class SimulationDto implements Serializable {

	private Integer period;

	private Integer amount;
	
	private float interest;

	private float monthlyPayment;
	
	private boolean fromCach;


	public SimulationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SimulationDto(Integer period, Integer amount, float interest, float monthlyPayment, boolean fromCach) {
		super();
		this.period = period;
		this.amount = amount;
		this.interest = interest;
		this.monthlyPayment = monthlyPayment ;
		this.fromCach = fromCach;
		
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

	public boolean isFromCach() {
		return fromCach;
	}

	public void setFromCach(boolean fromCach) {
		this.fromCach = fromCach;
	}
	
	
	
}
