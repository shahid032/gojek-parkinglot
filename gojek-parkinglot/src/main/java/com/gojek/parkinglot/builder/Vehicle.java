package com.gojek.parkinglot.builder;

/**
 * 
 * Generalized Vehicle interface, describing general characteristic of Vehicle
 * Equals and Hashcode are written in the implementations on the basis of Registration Number(not Case Sensitive)
 * @author Shahid
 *
 */
public interface Vehicle {
	
	public int slotSize();
	
	public String getColour();
	
	public String getRegistrationNumber();

}