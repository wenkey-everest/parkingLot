package com.everest.parkinglot.models;

import com.everest.parkinglot.enums.SpotType;
import com.everest.parkinglot.enums.Status;

import java.util.ArrayList;

public class Level {
    private static ArrayList<ParkingSpot> spots;

    public Level(int totalSlotsPerFloor) {
        spots = new ArrayList<>(totalSlotsPerFloor);
        truckSpots(0, 0);
        bikeSpots(1, 2);
        carSpots(3, totalSlotsPerFloor);
    }

    public void truckSpots(int startingSpot, int endingSpot) {
        for (int i = startingSpot; i <= endingSpot; i++)
            spots.add(i, new ParkingSpot(SpotType.TRUCK, i + 1, Status.FREE));

    }

    public void bikeSpots(int startingSpot, int endingSpot) {
        for (int i = startingSpot; i <= endingSpot; i++)
            spots.add(i, new ParkingSpot(SpotType.BIKE, i + 1, Status.FREE));

    }

    public void carSpots(int startingSpot, int endingSpot) {
        for (int i = startingSpot; i <= endingSpot; i++)
            spots.add(i, new ParkingSpot(SpotType.CAR, i + 1, Status.FREE));
    }


    public static ArrayList<ParkingSpot> getSpots() {
        return spots;
    }
}
