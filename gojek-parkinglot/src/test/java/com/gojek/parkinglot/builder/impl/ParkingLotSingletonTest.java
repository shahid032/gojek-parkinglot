package com.gojek.parkinglot.builder.impl;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gojek.parkinglot.api.ParkingLot;
import com.gojek.parkinglot.services.ParkingLotImpl;

public class ParkingLotSingletonTest {
	
	private ParkingLot parkingLot;
	
	@BeforeMethod
	public void setup(){
		parkingLot = ParkingLotSingleton.getParkingLotInstance();
	}
	
	@Test
	public void SingletonPropertyTest(){
		
		AssertJUnit.assertTrue(parkingLot == ParkingLotSingleton.getParkingLotInstance());
		AssertJUnit.assertFalse(parkingLot == new ParkingLotImpl());
	}

}
