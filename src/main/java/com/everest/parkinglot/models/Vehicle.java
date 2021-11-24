package com.everest.parkinglot.models;

import com.everest.parkinglot.enums.SpotType;

public interface Vehicle {
    String getRegNumber();

    String getColor();

    SpotType getSpotType();
}
