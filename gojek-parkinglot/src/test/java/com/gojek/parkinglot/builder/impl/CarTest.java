package com.gojek.parkinglot.builder.impl;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gojek.parkinglot.builder.Vehicle;

public class CarTest {

	private Vehicle car1;
	private Vehicle car2;
	
	@BeforeMethod
	public void setup(){
		car1 = new Car("Blue","1");
		car2 = new Car("Black","2");
	}
	
	@Test
	public void equalsTest(){
		
		AssertJUnit.assertEquals(car1.equals(null), false);
		AssertJUnit.assertEquals(car1.equals(car2), false);
		AssertJUnit.assertEquals(car1.equals(new Car("Black","1")), true);
		AssertJUnit.assertEquals(car1.equals(new Car("Blue","2")), false);
		
	}
	
	@Test 
	public void hascode(){
		
		AssertJUnit.assertFalse(car1.hashCode() == car2.hashCode());
		AssertJUnit.assertTrue(car1.hashCode() == new Car("Brown","1").hashCode());
		
	}
}
