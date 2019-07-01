package com.gojek.parkinglot.builder.impl;

import java.util.PriorityQueue;

/**
 * 
 * This class is a representation of total Parking space in our Parking lot
 * It is divided into sets one is available spaces in parking lot and the other is Occupied spaces
 * in parking lot.
 * Available spaces is implemented as Min Heap(Priority Queue in Java), so that it will get us nearest possible
 * available slot.
 * Go to Occupied Slots class to know more about it. 
 * 
 * @author Shahid
 *
 */
public class ParkingSlots {
	
	private PriorityQueue<Slot> availableSlots;
	private OccupiedSlots occupiedSlots;
	
	public ParkingSlots() {
		availableSlots = new PriorityQueue<Slot>(ParkingSlots::comparator);
		occupiedSlots = new OccupiedSlots();
	}
	
	public PriorityQueue<Slot> getAvailableSlots(){
		return this.availableSlots;
	}
	
	public OccupiedSlots getOccupiedSlots(){
		return this.occupiedSlots;
	}
	
	
	/*
	 * Comparator for priority queue
	 */
	public static int comparator(Slot x,Slot y) {
		return x.getId() - y.getId();
	}

}