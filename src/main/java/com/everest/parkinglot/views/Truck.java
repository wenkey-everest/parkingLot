package com.everest.parkinglot.views;

import com.everest.parkinglot.enums.SpotType;
import com.everest.parkinglot.models.Vehicle;

public class Truck implements Vehicle {
    private SpotType spotType;
    private String color;
    private String regNumber;

    public Truck(SpotType spotType, String color, String regNumber) {
        this.spotType = spotType;
        this.color = color;
        this.regNumber = regNumber;
    }

    @Override
    public String getRegNumber() {
        return regNumber;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public SpotType getSpotType() {
        return spotType;
    }


}
