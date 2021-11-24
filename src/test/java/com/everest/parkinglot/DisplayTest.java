package com.everest.parkinglot;

import com.everest.parkinglot.models.ParkingSpot;
import com.everest.parkinglot.services.ParkingLot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {
    @DisplayName("displayFreeCountTest")
    @Test
    public void displayFreeCountTest(){
        ParkingLot parkingLot = new ParkingLot(2,6);
        System.out.println("testing for number of free slots for car in each floor");
        Display display = new Display();
        int result = display.displayFreeCount(parkingLot, "Car");
        assertEquals(result,3,"free count for car in each vehicle is not 3");
    }


}