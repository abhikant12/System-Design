package parking;

import vehicle.Vehicle;


public class EntryGate{
    private String gateId;

    public EntryGate(String gateId){
        this.gateId= gateId;
    }

    public Ticket generateTicket(Vehicle v){
        if(!ParkingLot.INSTANCE.isParkingSpaceAvailable(v.getvType())) return null;

        ParkingSpace pSpace = ParkingLot.INSTANCE.findParkingSpace(v);
        pSpace.parkVehicle(v);
        return new Ticket(v, pSpace);
    }

    public String getGateId(){
        return gateId;
    }
    
}
