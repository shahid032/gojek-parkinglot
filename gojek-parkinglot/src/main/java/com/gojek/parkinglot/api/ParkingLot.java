package com.gojek.parkinglot.api;

import java.util.List;

import com.gojek.parkinglot.builder.impl.ParkingSlots;
import com.gojek.parkinglot.builder.impl.Slot;

/**
 * Different api's to create slots for Parking Lot and perform different operations 
 * 
 * @author shahid
 *
 */
public interface ParkingLot {
	
	/**
	 * 
	 * @param totalSlots is the total number of Slot created in Parking Lot
	 * @return return an object of ParkingSlots
	 */
	public boolean createParkingLot(int totalSlots);
	
	/**
	 * getter method for ParkingSlots for impl classes
	 * @return 
	 */
	public ParkingSlots getParkingSlots();
	
	/**
	 * 
	 * @param v take a Vehicle as an input parameter
	 * @return the slot assigned for parking , if not available return null;
	 */
	public Slot assignSlot(String clour,String regNum);
	
	/**
	 * 
	 * @param slot - is marked free 
	 * @return - return Slot which is marked free
	 */
	public Slot markSlotFree(Slot slot);
	
	/**
	 * 
	 * @param clour - colour of the Vehicle
	 * @return - List of registration numbers for Vehicle of a particular color
	 */
	public List<String> getRegNumByColour(String clour);
	
	/**
	 * 
	 * @param regNum - Registration number of the Vehicle
	 * @return - the slot it is assigned to and return null in case it is not parked
	 */
	public Slot getSlotNumByRegNum(String regNum);
	
	/**
	 * 
	 * @param colour - colour of the Vehicle
	 * @return - List of Slot assigned to a Vehicle of the given colour
	 */
	public List<Slot> getSlotByColour(String colour);
	
	
	
}