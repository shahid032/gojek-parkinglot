package com.gojek.parkinglot.builder.impl;

import com.gojek.parkinglot.constants.Constants;

/**
 * POGO for the slots in Parking lot
 * Overriden hashCode and equals on the basis of id assigned with the respective slots
 * @author Shahid
 *
 */

public class Slot {
	
	private int id;
	private int size;
	
	public Slot(int id){
		this.id = id;
		this.size = Constants.DEFAULT_SIZE;
	}
	
	Slot(int id, int size){
		this.id =id;
		this.size = size;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getsize() {
		return this.size;	
	}
	
	@SuppressWarnings("unused")
	@Override
	public int hashCode() {
		
		if(this == null)
			return Constants.DEFAULT_HASHCODE;
		return this.id;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || this == null)
			return false;
		if(obj instanceof Slot && ((Slot) obj).getId() == this.getId()) {
			return true;
		}
		return false;
		
	}

}