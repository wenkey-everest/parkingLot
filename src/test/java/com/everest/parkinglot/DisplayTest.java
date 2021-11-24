package com.everest.parkinglot;

import com.everest.parkinglot.models.ParkingSpot;
import com.everest.parkinglot.services.ParkingLot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {
    @DisplayName("displayFreeCount")
    @Test
    public void displayFreeCountTest(){
        ParkingLot parkingLot = new ParkingLot(2,6);
        System.out.println("testing for number of free slots for test vehicle(car) in each floor");
        Display display = new Display();
        int freeCount = display.displayFreeCount(parkingLot, "Car");
        assertEquals(freeCount,3,"free count for car in each vehicle is not 3");
    }
    @DisplayName("displayFreeSlots")
    @Test
    public void displayFreeSlotsTest(){
        ParkingLot parkingLot = new ParkingLot(2,6);
        System.out.println("testing for displaying available for test vehicle(car) in each floor");
        Display display = new Display();
        String freeSlots = display.displayFreeSlots(parkingLot,"Car");
        assertEquals(freeSlots,"4, 5, 6","free slots for test vehicle(car) is not same");
    }
    @DisplayName("displayOccupiedSlots")
    @Test
    public void displayOccupiedSlotsTest(){
        ParkingLot parkingLot = new ParkingLot(2,6);
        System.out.println("testing for occupied slots for test vehicle(car) in each floor");
        Display display = new Display();
        int occupiedSlots = display.displayOccupiedSlots(parkingLot,"Car");
        assertEquals(occupiedSlots,0,"occupiedSlots for test vehicle(car) is not 3");
    }

}