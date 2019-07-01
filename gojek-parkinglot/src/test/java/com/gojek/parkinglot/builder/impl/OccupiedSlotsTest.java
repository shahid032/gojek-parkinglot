package com.gojek.parkinglot.builder.impl;

import java.util.Map;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gojek.parkinglot.builder.Vehicle;

public class OccupiedSlotsTest {
	
	private Map<String,Slot> regNumberToSlot;
	private Map<Slot,Vehicle> slotToVehicle;
	private OccupiedSlots occupiedSlots;
	
	@BeforeMethod
	public void setup(){
		occupiedSlots = new OccupiedSlots();
		regNumberToSlot = occupiedSlots.getRegNumberToSlot();
		slotToVehicle = occupiedSlots.getSlotToVehicle();
	}
	
	@Test
	public void clearAndSizeTest(){
		
		regNumberToSlot.put("1", new Slot(1));
		regNumberToSlot.put("2", new Slot(2));
		slotToVehicle.put(new Slot(1), new Car("Blue","1"));
		slotToVehicle.put(new Slot(2), new Car("Black","2"));
		AssertJUnit.assertTrue(occupiedSlots.size() == 2);
		occupiedSlots.clear();
		AssertJUnit.assertTrue(occupiedSlots.size() == 0);
		
	}
	
	@Test
	public void addAndRemoveTest(){
		
		occupiedSlots.add(new Slot(1), new Car("Blue","1"));
		occupiedSlots.add(new Slot(2), new Car("Black","2"));
		AssertJUnit.assertTrue(occupiedSlots.size() == 2);
		occupiedSlots.add(new Slot(2), new Car("Brown","3"));
		AssertJUnit.assertTrue(occupiedSlots.size() == 2);
		occupiedSlots.add(new Slot(3), new Car("Brown","3"));
		AssertJUnit.assertTrue(occupiedSlots.size() == 3);
		AssertJUnit.assertTrue(occupiedSlots.remove(new Slot(4)) == null);
		AssertJUnit.assertTrue(occupiedSlots.remove(new Slot(1)).equals(new Slot(1)));
		AssertJUnit.assertTrue(occupiedSlots.size() == 2);
	}
	
	@Test
	public void comparator() {
		Slot newSlot = new Slot(1);
		Slot newSlot2 = new Slot(2);
		AssertJUnit.assertEquals(OccupiedSlots.comparator(newSlot, newSlot2), newSlot.getId()-newSlot2.getId());
	}

}
