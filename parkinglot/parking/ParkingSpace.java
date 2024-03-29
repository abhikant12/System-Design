package parking;

import vehicle.Vehicle;


public abstract class ParkingSpace{

    private String spaceId;
    private ParkingSpaceType pType;
    private Vehicle vehicle;
    boolean isEmpty;


    public ParkingSpace(String spaceId, ParkingSpaceType type){
        this.spaceId= spaceId;
        this.pType= type;
        this.isEmpty= true;

    }
    public void parkVehicle(Vehicle v)
    {
        isEmpty= false;
        vehicle= v;
    }
    public void removeVehicle()
    {
        vehicle= null;
        isEmpty= true;
    }
    public String getSpaceId() {
        return spaceId;
    }
    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }
    public ParkingSpaceType getpType() {
        return pType;
    }
    public void setpType(ParkingSpaceType pType) {
        this.pType = pType;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public boolean isEmpty() {
        return isEmpty;
    }
    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    
}
