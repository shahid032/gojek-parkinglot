package com.gojek.parkinglot.builder.impl;

import com.gojek.parkinglot.builder.Vehicle;
import com.gojek.parkinglot.constants.Constants;

public class Car implements Vehicle{
	
	private int slotsize;
	private String colour;
	private String regNumber;
	
	public Car(String colour,String regNumber){
		this.slotsize = Constants.DEFAULT_SIZE;
		this.colour = colour;
		this.regNumber = regNumber;
	}
	
	public Car(int slotsize, String colour,String regNumber){
		this.slotsize = slotsize;
		this.colour = colour;
		this.regNumber = regNumber;
	}
	
	@Override
	public int slotSize() {
		return this.slotsize;
	}

	@Override
	public String getColour() {
		return this.colour;
	}

	@Override
	public String getRegistrationNumber() {
		return this.regNumber;
	}
	
	@SuppressWarnings("unused")
	@Override
	public int hashCode() {
		
		if(this == null)
			return Constants.DEFAULT_HASHCODE;
		return this.regNumber.hashCode();
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || this == null)
			return false;
		if(obj instanceof Car && ((Car) obj).getRegistrationNumber() == this.getRegistrationNumber()) {
			return true;
		}
		return false;
		
	}
	

}
