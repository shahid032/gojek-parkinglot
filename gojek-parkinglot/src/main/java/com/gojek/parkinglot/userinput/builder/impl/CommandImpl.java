package com.gojek.parkinglot.userinput.builder.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import com.gojek.parkinglot.api.ParkingLot;
import com.gojek.parkinglot.builder.impl.ParkingLotSingleton;
import com.gojek.parkinglot.builder.impl.Slot;
import com.gojek.parkinglot.userinput.builder.Command;
import com.gojek.parkinglot.builder.Vehicle;

public class CommandImpl implements Command{
	
	ParkingLot parkingLot;
	
	
	public CommandImpl(){
		parkingLot = ParkingLotSingleton.getParkingLotInstance();
	}
	
	@Override
	public void call(String commandId, String[] args) throws IOException{
		
		if(commandId.equals("create_parking_lot")){
			createParkingLot(Integer.parseInt(args[0]));
		}
		else if(commandId.equals("park")){
			park(args[1], args[0]);
		}
		else if(commandId.equals("leave")){
			leave(new Slot(Integer.parseInt(args[0])));
		}
		else if(commandId.equals("status")){
			status();
		}
		else if(commandId.equals("registration_numbers_for_cars_with_colour")){
			printAllRegNumByColour(args[0]);
		}
		else if(commandId.equals("slot_numbers_for_cars_with_colour")){
			printAllSlotByClolour(args[0]);
		}
		else if(commandId.equals("slot_number_for_registration_number")){
			printSlotNumByRegNum(args[0]);
		}
		else if(commandId.equals("exit")){
			System.exit(0);
		}
		else{
			System.out.println("Invalid command");
		}
		
	}
	
	private void createParkingLot(int totalSlots){
		if(parkingLot.createParkingLot(totalSlots)){
			System.out.println("Created a parking lot with " +totalSlots+" slots");
		}
		else{
			System.out.println("Some Exception Occured while creating ParkingLot.");
		}
	}
	
	private void park(String clour,String regNum){
		Slot slot = parkingLot.assignSlot(clour, regNum);
		if(slot == null){
			System.out.println("Sorry, parking lot is full");
		}
		else{
			System.out.println("Allocated slot number: "+slot.getId());
		}
	}
	
	private void leave(Slot slot){
		
		parkingLot.markSlotFree(slot);
		System.out.println("Slot number "+slot.getId()+ " is free");
		
	}

	
	private void status(){
		
		String header = "Slot No."+"    "+"Registration No"+"    "+ "Colour";
		System.out.println(header);
		int regNoIdx = header.indexOf("Registration");
		int colourIdx = header.indexOf("Colour");
		for(Entry<Slot,Vehicle> entry : parkingLot.getParkingSlots().getOccupiedSlots().getSlotToVehicle().entrySet()){
			System.out.print(entry.getKey().getId());
			printSpaces(String.valueOf(entry.getKey().getId()).length(),regNoIdx);
			System.out.print(entry.getValue().getRegistrationNumber());
			printSpaces(regNoIdx+entry.getValue().getRegistrationNumber().length(), colourIdx);
			System.out.println(entry.getValue().getColour());
		}
		
	}

	private void printSpaces(int start, int end) {
		while(start<end){
			System.out.print(" ");
			start++;
		}
	}
	
	private void printAllRegNumByColour(String colour){
		
		List<String> allRegNumByColour = parkingLot.getRegNumByColour(colour);
		for(int i=0;i<allRegNumByColour.size()-1;i++)
			System.out.print(allRegNumByColour.get(i)+", ");
		System.out.println(allRegNumByColour.get(allRegNumByColour.size()-1));
	}
	
	private void printAllSlotByClolour(String colour){
		
		List<Slot> allSlotNumByColour = parkingLot.getSlotByColour(colour);
		for(int i=0;i<allSlotNumByColour.size()-1;i++)
			System.out.print(allSlotNumByColour.get(i).getId()+", ");
		System.out.println(allSlotNumByColour.get(allSlotNumByColour.size()-1).getId());
		
	}
	
	private void printSlotNumByRegNum(String regNum){
		
		if(parkingLot.getSlotNumByRegNum(regNum) == null)
			System.out.println("Not found");
		else{
			System.out.println(parkingLot.getSlotNumByRegNum(regNum).getId());
		}
		
	}
	
}
