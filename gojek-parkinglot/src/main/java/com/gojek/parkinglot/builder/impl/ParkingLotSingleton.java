package com.gojek.parkinglot.builder.impl;

import com.gojek.parkinglot.api.ParkingLot;
import com.gojek.parkinglot.services.ParkingLotImpl;


/**
 * Fatory method to get the instance of Parking Lot
 * @author shahid
 *
 */
public class ParkingLotSingleton {
	
	private static volatile ParkingLot obj = null;
	
	private ParkingLotSingleton(){}

	public static ParkingLot getParkingLotInstance(){
		
		if(obj == null){
			
			synchronized(ParkingLotSingleton.class){
				
				if(obj == null)
					obj = new ParkingLotImpl();
				
			}
			
		}
		return obj;
	}
}

