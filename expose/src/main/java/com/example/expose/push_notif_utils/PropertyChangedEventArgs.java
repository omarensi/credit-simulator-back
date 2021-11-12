package com.example.expose.push_notif_utils;

import com.example.expose.dtos.SimulationDto;

public class PropertyChangedEventArgs<T>{
    public T source; 
    public SimulationDto dto;
    
    
	public PropertyChangedEventArgs() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PropertyChangedEventArgs(T source, SimulationDto dto) {
		super();
		this.source = source;
		this.dto = dto;
	}

	
    
    
	
}
