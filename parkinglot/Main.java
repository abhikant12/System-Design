import admin.Address;
import admin.Admin;
import parking.*;
import vehicle.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome To Parking Lot");
        
        ParkingLot parkingLot = ParkingLot.INSTANCE;        

        Address address = new Address("Mega Mart Parking Complex", "Noida", "UttarPradesh", "India", "804453");
        parkingLot.setAddress(address);

        //Admin tests
        Admin admin = new Admin();
        Floor f1 = new Floor("1");                  //Admin should be able to add parking floor
        admin.addFloor(f1);
        Floor f2 = new Floor("2");
        admin.addFloor(f2);

        EntryGate entry1 = new EntryGate("1");      //Admin should be able to add entrance gate
        admin.addEntryGate(entry1);
        EntryGate entry2 = new EntryGate("1");
        admin.addEntryGate(entry2);
        
        ExitGate exit1= new ExitGate("1");          //Admin should be able to add exit gate
        admin.addExitGate(exit1);
        
        admin.setParkingStrategy(new NaturalOrderParking());      //Admin should be able to add parking strategy
        
        ParkingSpace carSpot1 = new CarParkingSpace("1");      //Admin should be able to add car parking space
        admin.addParkingSpace(f1, carSpot1);
        ParkingSpace bikeSpot1 = new BikeParkingSpace("2");      //Admin should be able to add bike parking space
        admin.addParkingSpace(f1, bikeSpot1);
        ParkingSpace carSpot2 = new CarParkingSpace("3");       //Admin should be able to add car parking space
        admin.addParkingSpace(f1, carSpot2);


        //Parking Test Cases
        System.out.println(ParkingLot.INSTANCE.isParkingSpaceAvailable(VehicleType.CAR));              //True;
        System.out.println(ParkingLot.INSTANCE.isParkingSpaceAvailable(VehicleType.BIKE));             //True;
        System.out.println(ParkingLot.INSTANCE.isParkingSpaceAvailable(VehicleType.TRUCK));            //false;
        System.out.println(ParkingLot.INSTANCE.getEntries().size());                                   // 2

      
        Vehicle vehicle1 = new BikeVehicle("KA05MR2311");
        Ticket ticket1 = entry1.generateTicket(vehicle1);
        System.out.println(null == ticket1);                                                             // false

        //Test Case 6 - Now we should not be able to park bike (only 1 parking space created for bike)
        System.out.println(ParkingLot.INSTANCE.isParkingSpaceAvailable(VehicleType.BIKE));               // false;

        //Test Case 7 - make payment for ticket1 (vehicle exists from exit1)
        Payment p1 = exit1.makePayment(PaymentType.UPI, new HourPaymentStrategy(), ticket1);
        System.out.println(p1.getAmount());                                                               // 0.0

        //Test Case 8 - Now we should be able to park bike "GHFD3452" entering from entry gate entry2
        Vehicle vehicle2 = new BikeVehicle("GHFD3452");
        Ticket ticket2 = entry2.generateTicket(vehicle2);
        System.out.println(null == ticket2);                                                              // false

        //Test Case 9 - check for total parking space created for car
        System.out.println(ParkingLot.INSTANCE.getFloorList().get(0).getpSpaces().get(ParkingSpaceType.CarParking).size());    // 2

    }
}
