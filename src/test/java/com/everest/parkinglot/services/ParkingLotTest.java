package com.everest.parkinglot.services;

import com.everest.parkinglot.enums.SpotType;
import com.everest.parkinglot.models.Vehicle;
import com.everest.parkinglot.views.Car;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    ParkingLot parkingLot;
    Vehicle vehicle;
    @BeforeEach
    public void parkingClass(){
        parkingLot = new ParkingLot(2,6);
        vehicle= new Car(SpotType.CAR, "White", "WB-45-HO-9032");
    }

    @DisplayName("parkTest")
    @Test
    public void parkTest() {
        boolean result = parkingLot.park(vehicle);
        assertTrue(result, "Vehicle is not parked i.e false");
    }

    @DisplayName("unParkTest")
    @Test
    public void unPark() {
        parkingLot.park(vehicle);
        Vehicle vehicle1 = parkingLot.unPark("PR1234_1_4");
        System.out.println("vehicle is unParked");
        assertEquals(vehicle, vehicle1, "In unPark the parked and unParked methods are not equal");
    }


}