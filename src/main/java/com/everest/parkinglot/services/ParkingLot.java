package com.everest.parkinglot.services;

import com.everest.parkinglot.models.Level;
import com.everest.parkinglot.models.ParkingSpot;
import com.everest.parkinglot.enums.SpotType;
import com.everest.parkinglot.models.Vehicle;

import java.util.*;

public class ParkingLot {
    private int NumberOfFloor;
    private int numberOfSlotsPerFloor;
    private Map<Integer, Level> floorMap;
    private List<ParkingSpot>[] levels;

    public ParkingLot(int NumberOfFloor, int numberOfSlotsPerFloor) {
        this.NumberOfFloor = NumberOfFloor;
        this.numberOfSlotsPerFloor = numberOfSlotsPerFloor;
        floorMap = new HashMap<>();
        levels = new List[NumberOfFloor];
        for (int i = 0; i < NumberOfFloor; i++) {
            floorMap.put(i, new Level(numberOfSlotsPerFloor));
            levels[i] = floorMap.get(i).getSpots();
        }
    }

    public boolean park(Vehicle v) {
        SpotType requestedSpotType = v.getSpotType();
        for (int i = 0; i < NumberOfFloor; i++) {
            List<ParkingSpot> spot = levels[i];
            for (int j = 0; j < spot.size(); j++) {
                if (spot.get(j).getSpotType().equals(requestedSpotType)) {
                    if (spot.get(j).getStatus().equalsIgnoreCase("free")) {
                        spot.get(j).parkVehicle(v);
                        System.out.println("Parked vehicle. Ticket ID: PR1234_" + (i + 1) + "_" + spot.get(j).getSpotNumber());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Vehicle unPark(String ticket_Id) {
        try {
            String[] ticket = ticket_Id.split("_", -1);
            int floor = Integer.parseInt(ticket[1]) - 1;
            int spotNumber = Integer.parseInt(ticket[2]) - 1;
            ParkingSpot spot = levels[floor].get(spotNumber);
            if (spot.getStatus().equalsIgnoreCase("occupied")) {
                return spot.unParkVehicle();
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return null;
    }

    public int getNumberOfFloor() {
        return NumberOfFloor;
    }

    public int getNumberOfSlotsPerFloor() {
        return numberOfSlotsPerFloor;
    }

    public List<ParkingSpot> getLevels(int index) {
        return levels[index];
    }
}
