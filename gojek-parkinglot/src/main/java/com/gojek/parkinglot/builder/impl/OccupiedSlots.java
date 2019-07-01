package com.gojek.parkinglot.builder.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.gojek.parkinglot.builder.Vehicle;

/**
 * POGO for occupied slots in our parking lot.
 * Occupied slots is represented as a two maps
 * first is mapping Registration number to Slot
 * Second one is mapping the Slot to Vehicle
 * Different operations are written to perform add, remove,size
 * @author shahid
 *
 */

public class OccupiedSlots {
	
	private Map<String,Slot> regNumberToSlot;
	private Map<Slot,Vehicle> slotToVehicle;
	
	public OccupiedSlots() {
		regNumberToSlot = new HashMap<String,Slot>();
		slotToVehicle = new TreeMap<Slot,Vehicle>(OccupiedSlots::comparator);
	}
	
	public Map<String,Slot> getRegNumberToSlot(){
		return this.regNumberToSlot;
	}
	
	public Map<Slot,Vehicle> getSlotToVehicle(){
		return this.slotToVehicle;
	}
	
	public void clear(){
		regNumberToSlot.clear();
		slotToVehicle.clear();
	}
	
	public int size(){
		return regNumberToSlot.size();
	}
	
	public boolean add(Slot slot,Vehicle v){
		
		if(slotToVehicle.containsKey(slot)){
			return false;
		}
		regNumberToSlot.put(v.getRegistrationNumber(),slot);
		slotToVehicle.put(slot, v);
		return true;
		
	}
	
	public Slot remove(Slot slot){
		
		if(regNumberToSlot.isEmpty() || !slotToVehicle.containsKey(slot))
			return null;
		regNumberToSlot.remove(slotToVehicle.get(slot).getRegistrationNumber());
		slotToVehicle.remove(slot);
		return slot;
	}
	
	/*
	 * Comparator for TreeMap
	 */
	public static int comparator(Slot x,Slot y) {
		return x.getId() - y.getId();
	}

}