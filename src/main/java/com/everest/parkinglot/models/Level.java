package com.everest.parkinglot.models;

import com.everest.parkinglot.enums.SpotType;

import java.util.ArrayList;

public class Level {
    private static ArrayList<ParkingSpot> spots;
    private int totalSlotsPerFloor;

    public Level(int totalSlotsPerFloor) {
        this.totalSlotsPerFloor = totalSlotsPerFloor;
        spots = new ArrayList<>(totalSlotsPerFloor);
        for(int i=0;i<totalSlotsPerFloor;i++){
            if(i==0){
                spots.add(i,new ParkingSpot(SpotType.TRUCK,i+1, "free"));
            }else if(i==1 || i==2){
                spots.add(i,new ParkingSpot(SpotType.BIKE,i+1,"free"));
            }else
                spots.add(i,new ParkingSpot(SpotType.CAR,i+1,"free"));
            }
        }
    public static ArrayList<ParkingSpot> getSpots() {
        return spots;
    }
}
