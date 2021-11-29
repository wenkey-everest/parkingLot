package com.everest.parkinglot;

import com.everest.parkinglot.enums.Status;
import com.everest.parkinglot.services.ParkingLot;
import com.everest.parkinglot.models.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class Display {
    private int count;
    private String tempCount;

    public int displayFreeCount(ParkingLot parkingLot, String vehicleType) {
        for (int i = 0; i < parkingLot.getNumberOfFloor(); i++) {
            count = 0;
            for (int j = 0; j < parkingLot.getNumberOfSlotsPerFloor(); j++) {
                ParkingSpot spot = parkingLot.getLevels(i).get(j);
                if (spot.getSpotType().toString().equalsIgnoreCase(vehicleType)) {
                    if (spot.getStatus().equals(Status.FREE)) {
                        count++;
                    }
                }
            }
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + (i + 1) + " : " + count);
        }
        return count;
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
            List<Integer> count1 = new ArrayList<>();
            for (int j = 0; j < parkingLot.getNumberOfSlotsPerFloor(); j++) {
                ParkingSpot spot = parkingLot.getLevels(i).get(j);
                if (spot.getSpotType().toString().equalsIgnoreCase(vehicleType)) {
                    if (spot.getStatus().equals(status)) {
                        count1.add(spot.getSpotNumber());
                    }
                }
            }
            tempCount = count1.toString().replace("[", "").replace("]", "");
            System.out.println(inputString + " " + vehicleType + " on Floor " + (i + 1) + " : " + tempCount);
        }
    }
}