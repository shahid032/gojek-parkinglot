package com.gojek.parkinglot.userinput.builder;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gojek.parkinglot.api.ParkingLot;
import com.gojek.parkinglot.builder.impl.ParkingLotSingleton;
import com.gojek.parkinglot.userinput.builder.impl.CommandImpl;

public class CommandTest {
	
	ParkingLot parkingLot;
	Command cmd;
	@BeforeMethod
	public void setup(){
		parkingLot = ParkingLotSingleton.getParkingLotInstance();
		cmd = new CommandImpl();
	}
	
	@Test
	public void callCreateTest() throws IOException{
		
		
		String commandId = "create_parking_lot";
		String args = "6";
		cmd.call(commandId,args.split(" "));
	}
	
	@Test
	public void callParkAndLeaveTest() throws IOException{
		parkingLot.createParkingLot(6);
		String commandId = "park";
		String args = "KA-01-HH-1234 White";
		cmd.call(commandId,args.split(" "));
		args = "KA-01-HH-9999 White";
		cmd.call(commandId,args.split(" "));
		args = "KA-01-BB-0001 Black";
		cmd.call(commandId,args.split(" "));
		args = "KA-01-HH-7777 Red";
		cmd.call(commandId,args.split(" "));
		args = "KA-01-HH-2701 Blue";
		cmd.call(commandId,args.split(" "));
		args = "KA-01-HH-3141 Black";
		cmd.call(commandId,args.split(" "));
		args = "KA-01-HH-3141 Black";
		cmd.call(commandId,args.split(" "));
		
		cmd.call("leave", "4".split(" "));
		cmd.call("leave", "12".split(" "));
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getAvailableSlots().size() == 1);
		AssertJUnit.assertTrue(parkingLot.getParkingSlots().getOccupiedSlots().size() == 5);
		
	}
	
	@Test
	public void callStatusTest() throws IOException{
		cmd.call("status", "".split(" "));
	}
	
	@Test
	public void callprintAllRegNumByColourTest() throws IOException{
		cmd.call("park","KA-01-P-333 White".split(" "));
		cmd.call("park","park DL-12-AA-9999 White".split(" "));
		cmd.call("registration_numbers_for_cars_with_colour", "White".split(" "));
	}
	
	@Test
	public void callprintAllSlotByClolourTest() throws IOException{
		cmd.call("slot_numbers_for_cars_with_colour", "White".split(" "));
	}
	
	@Test
	public void callprintSlotNumByRegNumTest() throws IOException{
		cmd.call("slot_number_for_registration_number", "KA-01-HH-3141".split(" "));
		cmd.call("slot_number_for_registration_number", "MH-04-AY-1111".split(" "));
	}
	

}
