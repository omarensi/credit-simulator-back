package com.example.compute.dtos;

public class SimulationDto {

	private Integer period;

	private Integer amount;
	
	private float interest;

	private float monthlyPayment;


	public SimulationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SimulationDto(Integer period, Integer amount, float interest, float monthlyPayment) {
		super();
		this.period = period;
		this.amount = amount;
		this.interest = interest;
		this.monthlyPayment = monthlyPayment ;
		
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
