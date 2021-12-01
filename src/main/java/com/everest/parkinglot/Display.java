package com.everest.parkinglot;

import com.everest.parkinglot.enums.Status;
import com.everest.parkinglot.models.Vehicle;
import com.everest.parkinglot.services.ParkingLot;
import com.everest.parkinglot.models.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class Display {
    private int count;
    private String tempCount;

    public void displayFreeCount(ParkingLot parkingLot, String vehicleType){
        for (int i = 0; i < parkingLot.getNumberOfFloor(); i++) {
            displayFreeCountForLoop2(i, parkingLot, vehicleType);
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + (i + 1) + " : " + count);
        }
    }
    public void displayFreeCountForLoop2(int i,ParkingLot parkingLot, String vehicleType){
        count=0;
        for (int j = 0; j < parkingLot.getNumberOfSlotsPerFloor(); j++) {
            ParkingSpot spot = parkingLot.getLevels(i).get(j);
            displayFreeCountForLoop3(spot, vehicleType);
        }
    }
    public void displayFreeCountForLoop3(ParkingSpot spot, String vehicleType){
    if (spot.getSpotType().toString().equalsIgnoreCase(vehicleType)) {
        if (spot.getStatus().equals(Status.FREE)) {
            count++;
        }
    }
}
    public String displayFreeSlots(ParkingLot parkingLot, String vehicleType) {
        displayHandler(parkingLot, vehicleType, Status.FREE, "Free slots for");
        return tempCount;
    }

    public String displayOccupiedSlots(ParkingLot parkingLot, String vehicleType) {
        displayHandler(parkingLot, vehicleType, Status.OCCUPIED, "Occupied slots for");
        return tempCount;
    }

    public void displayHandler(ParkingLot parkingLot, String vehicleType, Status status, String inputString) {
        for (int i = 0; i < parkingLot.getNumberOfFloor(); i++) {
           displayHandlerLoop2(parkingLot, vehicleType, status, i);
           System.out.println(inputString + " " + vehicleType + " on Floor " + (i + 1) + " : " + tempCount);
        }
    }
    public void displayHandlerLoop2(ParkingLot parkingLot, String vehicleType, Status status, int i){
        List<Integer> count1 = new ArrayList<>();
        for (int j = 0; j < parkingLot.getNumberOfSlotsPerFloor(); j++) {
            ParkingSpot spot = parkingLot.getLevels(i).get(j);
            displayHandlerLoop3(spot,vehicleType,status,count1);
        }
        tempCount = count1.toString().replace("[", "").replace("]", "");
    }
    public void displayHandlerLoop3(ParkingSpot spot, String vehicleType, Status status, List<Integer> count1){
        if (spot.getSpotType().toString().equalsIgnoreCase(vehicleType)) {
            if (spot.getStatus().equals(status)) {
                count1.add(spot.getSpotNumber());
            }
        }
    }

}