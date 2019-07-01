package com.gojek.parkinglot.builder.impl;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;

public class ParkingSlotsTest {
	Slot newSlot,newSlot2;
	
	@BeforeMethod
	public void setup() {
		newSlot = new Slot(1);
		newSlot2 = new Slot(2);
	}
	
	@Test
	public void testPQComparator() {
		AssertJUnit.assertEquals(ParkingSlots.comparator(newSlot, newSlot2), newSlot.getId()-newSlot2.getId());
	}
}
