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
	 * @return return an true is the Slots are created else return false
	 */
	public boolean createParkingLot(int totalSlots);
	
	/**
	 * getter method for ParkingSlots for impl classes
	 * @return 
	 */
	public ParkingSlots getParkingSlots();
	
	/**
	 * This method is corresponding to command Park and will assign the available slot
	 * @param clour - colour of the Vehicle
	 * @param regNum - registration Number of the Vehicle 
	 * @return the slot assigned for parking , if not available return null;
	 * if vehicle with the same registration number is already present , it will return Slot(0) which is not define
	 * i.e. on console it will show Error in Assigning Slot - Registration number is not Unique.
	 */
	public Slot assignSlot(String clour,String regNum);
	
	/**
	 * This method is corresponding to command "leave". 
	 * @param slot - is marked free 
	 * @return - return Slot which is marked free. In case Slot is already free it will return null
	 * And will print the same output on the console.
	 * If requested Slot is more than the total slots return Slot 0 which is not define
	 */
	public Slot markSlotFree(Slot slot);
	
	/**
	 * 
	 * @param clour - colour of the Vehicle(not case sensitive)
	 * @return - List of registration numbers for Vehicle of a particular color
	 */
	public List<String> getRegNumByColour(String clour);
	
	/**
	 * 
	 * @param regNum - Registration number of the Vehicle (case sensitive)
	 * @return - the slot it is assigned to and return null in case it is not parked
	 */
	public Slot getSlotNumByRegNum(String regNum);
	
	/**
	 * 
	 * @param colour - colour of the Vehicle(not case sensitive)
	 * @return - List of Slot assigned to a Vehicle of the given colour
	 */
	public List<Slot> getSlotByColour(String colour);
	
	
	
}