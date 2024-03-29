package parking;

import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor{

    private final String floorId;
    private Map<ParkingSpaceType, List<ParkingSpace>> pSpaces = new HashMap<>();

    public Floor(String floorId){
        this.floorId= floorId;
        pSpaces.put(ParkingSpaceType.BikeParking, new ArrayList<>());
        pSpaces.put(ParkingSpaceType.CarParking, new ArrayList<>());
        pSpaces.put(ParkingSpaceType.TruckParking, new ArrayList<>());
    }

    public void addParkingSpace(ParkingSpace p){
        pSpaces.get(p.getpType()).add(p);
    }
    public void removeParkingSpace(ParkingSpace p){
        pSpaces.get(p.getpType()).remove(p);
    }
    public boolean canParkVehicle(VehicleType vType){
        for(ParkingSpace p: pSpaces.get(getSpaceTypeForVehicle(vType))){
            if(p.isEmpty)  return true;
        }
        return false;
    }
    private ParkingSpaceType getSpaceTypeForVehicle(VehicleType vType){
        switch (vType) {
            case CAR:
                return ParkingSpaceType.CarParking;
            case BIKE:
                return ParkingSpaceType.BikeParking;
            case TRUCK:
                return ParkingSpaceType.TruckParking;

        }
        return null;
    }
    public ParkingSpace getSpace(Vehicle v){
        List<ParkingSpace> availableSpaces= new ArrayList<>();
        for(ParkingSpace p: pSpaces.get(getSpaceTypeForVehicle(v.getvType())))
            if(p.isEmpty)
                availableSpaces.add(p);
        return ParkingLot.INSTANCE.getpStrategy().park(availableSpaces);
    }

    public String getFloorId() {
        return floorId;
    }

    public Map<ParkingSpaceType, List<ParkingSpace>> getpSpaces() {
        return pSpaces;
    }

    public void setpSpaces(Map<ParkingSpaceType, List<ParkingSpace>> pSpaces) {
        this.pSpaces = pSpaces;
    }
}
