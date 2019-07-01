package com.gojek.parkinglot.builder.impl;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SlotTest {
	
	private Slot slot1;
	private Slot slot2;
	
	@BeforeMethod
	public void setup(){
		slot1 = new Slot(1);
		slot2 = new Slot(2);
	}
	
	@Test
	public void equalsTest(){
		
		AssertJUnit.assertEquals(slot1.equals(null), false);
		AssertJUnit.assertEquals(slot1.equals(slot2), false);
		AssertJUnit.assertEquals(slot1.equals(new Slot(1)), true);
		AssertJUnit.assertEquals(slot1.equals(new SlotTest()), false);
		
	}
	
	@Test 
	public void hascode(){
		
		AssertJUnit.assertEquals(slot1.hashCode(), slot1.getId());
		
	}

}
