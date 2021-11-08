package com.jrp.pma.SimpleClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	Tire tires;
	Engine e;
	Doors d;
	
	public Car(Tire tires, Engine e, Doors d) {
		super();
		this.tires = tires;
		this.e = e;
		this.d = d;
	}

//	@Autowired
//	public void setD(Doors d) {
//		this.d = d;
//	}	
	
	
	
	
}
