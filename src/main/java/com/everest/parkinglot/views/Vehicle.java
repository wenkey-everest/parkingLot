package com.everest.parkinglot.views;

import com.everest.parkinglot.enums.SpotType;

public abstract class Vehicle {

    private SpotType spotType;
    private String color;
    private String regNumber;

    public Vehicle(SpotType spotType, String color, String regNumber) {
        this.spotType = spotType;
        this.color = color;
        this.regNumber = regNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }


    public String getColor() {
        return color;
    }

    public SpotType getSpotType() {
        return spotType;
    }
}


