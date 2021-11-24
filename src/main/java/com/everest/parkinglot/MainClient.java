package com.everest.parkinglot;

import com.everest.parkinglot.enums.SpotType;
import com.everest.parkinglot.models.Vehicle;
import com.everest.parkinglot.services.ParkingLot;
import com.everest.parkinglot.views.Bike;
import com.everest.parkinglot.views.Car;
import com.everest.parkinglot.views.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClient {
    private static ParkingLot parkingLot;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] commandText;
        Vehicle vehicle;
        do {
            commandText = bufferedReader.readLine().split(" ");
            switch (commandText[0]){
                case "create_parking_lot":
                    parkingLot = new ParkingLot(Integer.parseInt(commandText[2]),Integer.parseInt(commandText[3]));
                    System.out.println("Created parking lot with "+(Integer.parseInt(commandText[2]))+" floors and "+(Integer.parseInt(commandText[3]))+ " slots per floor");
                    break;
                case "display":
                    Display display = new Display();
                        if(commandText[1].equalsIgnoreCase("free_count")){
                                display.displayFreeCount(parkingLot,commandText[2]);
                        }else if(commandText[1].equalsIgnoreCase("free_slots")) {
                            display.displayFreeSlots(parkingLot, commandText[2]);
                        }else if(commandText[1].equalsIgnoreCase("occupied_slots")){
                            display.displayOccupiedSlots(parkingLot, commandText[2]);
                        }
                    break;
                case "park_vehicle":
                    if (commandText[1].equalsIgnoreCase("car")){
                         vehicle= new Car(SpotType.CAR,commandText[3],commandText[2]);
                    }else if(commandText[1].equalsIgnoreCase("bike")){
                        vehicle=new Bike(SpotType.BIKE,commandText[3],commandText[2]);
                    }else {
                        vehicle=new Truck(SpotType.TRUCK,commandText[3],commandText[2]);
                    }
                    if(parkingLot.park(vehicle)){
                    }else{
                        System.out.println("ParkingLot is full");
                    }

                    break;
                case "unpark_vehicle":
                        vehicle=parkingLot.unPark(commandText[1]);
                        if(vehicle!=null){
                            System.out.println("Unparked vehicle with Registration Number: "+vehicle.getRegNumber()+" and Color: " +vehicle.getColor());
                        }else{
                            System.out.println("Invalid Ticket");
                        }
                        break;
                default:
                    break;
            }
        }while (!commandText[0].equalsIgnoreCase("exit"));
    }
}
