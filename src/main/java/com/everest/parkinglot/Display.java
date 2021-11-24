package com.everest.parkinglot;
import com.everest.parkinglot.services.ParkingLot;
import com.everest.parkinglot.models.ParkingSpot;
import java.util.ArrayList;
import java.util.List;


public class Display {
    private int count = 0;
    private String tempCount;
    public int displayFreeCount(ParkingLot parkingLot, String vehicleType) {
        for (int i = 0; i < parkingLot.getNumberOfFloor(); i++) {
            count = 0;
            for (int j = 0; j < parkingLot.getNumberOfSlotsPerFloor(); j++) {
                ParkingSpot spot = parkingLot.getLevels(i).get(j);
                if (spot.getSpotType().toString().equalsIgnoreCase(vehicleType)) {
                    if (spot.getStatus().equalsIgnoreCase("free")) {
                        count++;
                    }
                }
            }
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + (i + 1) + " : " + count);

        }
        return count;
    }

    public String displayFreeSlots(ParkingLot parkingLot, String vehicleType) {
        for (int i = 0; i < parkingLot.getNumberOfFloor(); i++) {
            List<Integer> count = new ArrayList<>();
            for (int j = 0; j < parkingLot.getNumberOfSlotsPerFloor(); j++) {
                ParkingSpot spot = parkingLot.getLevels(i).get(j);
                if (spot.getSpotType().toString().equalsIgnoreCase(vehicleType)) {
                    if (spot.getStatus().equalsIgnoreCase("free")) {
                        count.add(spot.getSpotNumber());
                    }
                }
            }
            tempCount =  count.toString().replace("[", "").replace("]", "");
            System.out.println("Free slots for " + vehicleType + " on Floor " + (i + 1) + " : " + tempCount);
        }
        return tempCount;
    }

    public int displayOccupiedSlots(ParkingLot parkingLot, String vehicleType) {
        for (int i = 0; i < parkingLot.getNumberOfFloor(); i++) {
            count = 0;
            for (int j = 0; j < parkingLot.getNumberOfSlotsPerFloor(); j++) {
                ParkingSpot spot = parkingLot.getLevels(i).get(j);
                if (spot.getSpotType().toString().equalsIgnoreCase(vehicleType)) {
                    if (spot.getStatus().equalsIgnoreCase("occupied")) {
                        count++;
                    }
                }
            }
            System.out.println("Occupied slots for " + vehicleType + " on Floor " + (i + 1) + " : " + count);
        }
        return count;
    }
}
