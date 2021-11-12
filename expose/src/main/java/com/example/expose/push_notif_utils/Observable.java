package com.example.expose.push_notif_utils;

import java.util.ArrayList;
import java.util.List;

import com.example.expose.dtos.SimulationDto;

public class Observable<T>  {

	    public List<Observer<T>> observers = new ArrayList<Observer<T>>(); 

	    public void subscribe(Observer<T> observer) {
	        this.observers.add(observer); 
	    }

	    protected void notifyObservers(T source, SimulationDto dto) {
	        for (Observer<T> o : observers) {
	            o.handle(new PropertyChangedEventArgs<T>(source, dto));
	        }
	    } 
	}
