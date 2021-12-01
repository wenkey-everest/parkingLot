package com.everest.parkinglot.models;
import com.everest.parkinglot.views.Vehicle;
import com.everest.parkinglot.enums.SpotType;
import com.everest.parkinglot.enums.Status;

public class ParkingSpot {
    private Status status;
    private final SpotType spotType;
    private  Vehicle vehicle;
    private final int spotNumber;

    public ParkingSpot(SpotType spotType, int spotNumber, Status status) {
        this.spotType = spotType;
        this.status = status;
        this.spotNumber = spotNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void parkVehicle(Vehicle v) {
        this.vehicle = v;
        this.setStatus(Status.OCCUPIED);
    }

    public Vehicle unParkVehicle() {
        Vehicle v = this.vehicle;
        this.vehicle = null;
        this.setStatus(Status.FREE);
        return v;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
