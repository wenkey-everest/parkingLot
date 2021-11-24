package com.everest.parkinglot.models;

import com.everest.parkinglot.enums.SpotType;

public class ParkingSpot {
    private String status;
    private SpotType spotType;
    private Vehicle vehicle;
    private int spotNumber;

    public ParkingSpot(SpotType spotType, int spotNumber, String status) {
        this.spotType = spotType;
        this.status=status;
        this.spotNumber=spotNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void parkVehicle(Vehicle v) {
        this.vehicle=v;
    }
    public Vehicle unParkVehicle(){
        Vehicle v= this.vehicle;
        this.vehicle=null;
        return v;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
