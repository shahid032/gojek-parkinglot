package com.gojek.parkinglot.services;

import com.gojek.parkinglot.api.ParkingLot;
import com.gojek.parkinglot.builder.Vehicle;
import com.gojek.parkinglot.builder.impl.ParkingSlots;
import com.gojek.parkinglot.builder.impl.Slot;
import com.gojek.parkinglot.builder.impl.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class ParkingLotImpl implements ParkingLot{
	
	
	private ParkingSlots parkingSlots;
	
	public ParkingLotImpl() {
		parkingSlots = new ParkingSlots();
	}
	
	@Override
	public boolean createParkingLot(int totalNumSlots) {
		
		try{
			parkingSlots.getAvailableSlots().clear();
			parkingSlots.getOccupiedSlots().clear();
			IntStream.range(1,totalNumSlots+1).forEach((n)->parkingSlots.getAvailableSlots().add(new Slot(n)));
		}
		catch(Exception ex){
			return false;
		}
		return true;
	}

	@Override
	public ParkingSlots getParkingSlots() {
		
		return this.parkingSlots;
	}

	@Override
	public Slot assignSlot(String colour,String regNum) {
		
		Vehicle v = new Car(colour,regNum);
		if(parkingSlots.getAvailableSlots().isEmpty())
			return null;
		Slot nextNearestAvilSlot = parkingSlots.getAvailableSlots().poll();
		parkingSlots.getOccupiedSlots().add(nextNearestAvilSlot, v);
		return nextNearestAvilSlot;
		
	}
	
	// in case of null return. either no Vehicle is parked or that slot is not available
	@Override
	public Slot markSlotFree(Slot slot) {
		
		Slot freeSlot = parkingSlots.getOccupiedSlots().remove(slot);
		if(freeSlot != null){
			parkingSlots.getAvailableSlots().add(freeSlot);
		}
		return freeSlot;
	}

	@Override
	public List<String> getRegNumByColour(String colour) {
		
		List<String> regNumberByColour = new ArrayList<String>();
		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		Map<String,Slot> regNumToSlot = parkingSlots.getOccupiedSlots().getRegNumberToSlot();
		Map<Slot,Vehicle> slotToVehicle = parkingSlots.getOccupiedSlots().getSlotToVehicle();
		for(Entry<String,Slot> regNumToSlotEntry : regNumToSlot.entrySet()){
			
			if(slotToVehicle.get(regNumToSlotEntry.getValue()).getColour().equalsIgnoreCase(colour)){
				ArrayList<String> al = new ArrayList<String>();
				al.add(regNumToSlotEntry.getKey());
				al.add(String.valueOf(regNumToSlotEntry.getValue().getId()));
				temp.add(al);
			}
			
		}
		Collections.sort(temp,(x,y) -> x.get(1).compareTo(y.get(1)));
		temp.forEach((list)-> regNumberByColour.add(list.get(0)));
		
		return regNumberByColour;
	}

	@Override
	public Slot getSlotNumByRegNum(String regNum) {
		
		if(!parkingSlots.getOccupiedSlots().getRegNumberToSlot().containsKey(regNum))
			return null;
		
		return parkingSlots.getOccupiedSlots().getRegNumberToSlot().get(regNum);
	}

	@Override
	public List<Slot> getSlotByColour(String colour) {
		
		List<Slot> slotByColour = new ArrayList<Slot>();
		Map<Slot,Vehicle> slotToVehicle = parkingSlots.getOccupiedSlots().getSlotToVehicle();
		for(Entry<Slot,Vehicle> slotToVehicleEntry : slotToVehicle.entrySet()){
			
			if(slotToVehicleEntry.getValue().getColour().equalsIgnoreCase(colour)){
				slotByColour.add(slotToVehicleEntry.getKey());
			}
			
		}
		
		return slotByColour;
	}
	
	
	

}
