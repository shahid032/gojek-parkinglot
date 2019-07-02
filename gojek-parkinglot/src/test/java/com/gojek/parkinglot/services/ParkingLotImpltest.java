package com.gojek.parkinglot.services;

import java.util.List;
import java.util.stream.IntStream;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gojek.parkinglot.api.ParkingLot;
import com.gojek.parkinglot.builder.impl.ParkingLotSingleton;
import com.gojek.parkinglot.builder.impl.Slot;

public class ParkingLotImpltest {
	
	ParkingLot parkingLot;
	
	@BeforeMethod
	public void setup(){
		parkingLot = ParkingLotSingleton.getParkingLotInstance();
		parkingLot.createParkingLot(0);
	}
	
	@Test
	public void createParkingLotTest(){
		
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getAvailableSlots().size() == 0);
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getOccupiedSlots().size() == 0);
		parkingLot.createParkingLot(6);
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getAvailableSlots().size() == 6);
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getOccupiedSlots().size() == 0);
		parkingLot.createParkingLot(0);
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getAvailableSlots().size() == 0);
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getOccupiedSlots().size() == 0);
	}
	
	@Test
	public void assignAndMarkSlotTest(){
		
		parkingLot.createParkingLot(6);
		IntStream.range(1,6).forEach((i)->parkingLot.assignSlot("Blue",String.valueOf(i)));
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getAvailableSlots().size() == 1);
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getOccupiedSlots().size() == 5);
		parkingLot.assignSlot("Blue","6");
		AssertJUnit.assertTrue(parkingLot.assignSlot("Blue","7") == null);
		parkingLot.markSlotFree(new Slot(1));
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getOccupiedSlots().size() == 5);
		parkingLot.assignSlot("Brown","7");
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getOccupiedSlots().getRegNumberToSlot().get("7").equals(new Slot(1)));
		AssertJUnit.assertTrue(parkingLot.markSlotFree(new Slot(12)).equals(new Slot(0)));
		AssertJUnit.assertTrue(parkingLot.assignSlot("Black","2").equals(new Slot(0)));
	}
	
	@Test
	public void getRegNumByColourTest(){
		
		parkingLot.createParkingLot(6);
		IntStream.range(1,5).forEach((i)->parkingLot.assignSlot("Blue",String.valueOf(i)));
		parkingLot.assignSlot("Black","5");
		parkingLot.assignSlot("Blue","6");
		parkingLot.getRegNumByColour("Blue");
		List<String> regNumberByColour = parkingLot.getRegNumByColour("blue");
		AssertJUnit.assertTrue(regNumberByColour.size() == 5);
		AssertJUnit.assertTrue(regNumberByColour.get(4).equals("6"));
		parkingLot.markSlotFree(new Slot(1));
		regNumberByColour = parkingLot.getRegNumByColour("Blue");
		AssertJUnit.assertTrue(regNumberByColour.size() == 4);
		AssertJUnit.assertTrue(regNumberByColour.get(3).equals("6"));
	
	}
	
	@Test
	public void getSlotNumByRegNumTest(){
		
		parkingLot.createParkingLot(6);
		IntStream.range(1,5).forEach((i)->parkingLot.assignSlot("Blue",String.valueOf(i)));
		AssertJUnit.assertTrue(parkingLot.getSlotNumByRegNum("2").equals(new Slot(2)));
		AssertJUnit.assertFalse(parkingLot.getSlotNumByRegNum("2").equals(new Slot(6)));
		AssertJUnit.assertTrue(parkingLot.getSlotNumByRegNum("12") == null);
		parkingLot.markSlotFree(new Slot(2));
		parkingLot.assignSlot("blue", "KawR516");
		AssertJUnit.assertTrue(parkingLot.getSlotNumByRegNum("kaWr516") == null);
		
	}
	
	@Test
	public void getSlotByClourTest(){
		
		parkingLot.createParkingLot(6);
		IntStream.range(1,5).forEach((i)->parkingLot.assignSlot("Blue",String.valueOf(i)));
		parkingLot.assignSlot("Black","5");
		parkingLot.assignSlot("Blue","6");
		parkingLot.getRegNumByColour("Blue");
		AssertJUnit.assertTrue(parkingLot.getSlotByColour("Blue").size() == 5);
		parkingLot.markSlotFree(new Slot(1));
		parkingLot.assignSlot("Black","7");
		AssertJUnit.assertTrue(parkingLot.getSlotByColour("blue").size() == 4);
		AssertJUnit.assertTrue(parkingLot.getSlotByColour("black").size() == 2);
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getOccupiedSlots().getSlotToVehicle().get(new Slot(1)).getColour().equals("Black"));

	}
	
}
