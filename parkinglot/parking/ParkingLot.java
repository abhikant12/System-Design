package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import admin.Address;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingLot{

    private String pLotId;
    private List<Floor> floorList;
    private List<EntryGate> entries;
    private List<ExitGate> exits;
    private Address address;
    private ParkingStrategy pStrategy;

    public static ParkingLot INSTANCE = new ParkingLot();                    //sigleton

    private ParkingLot(){
        pLotId= UUID.randomUUID().toString();
        floorList = new ArrayList<>();
        entries= new ArrayList<>();
        exits= new ArrayList<>();
    }

    public boolean isParkingSpaceAvailable(VehicleType vType){
        for(Floor floor : floorList){
            return floor.canParkVehicle(vType);
        }
        return false;
    }
    public ParkingSpace findParkingSpace(Vehicle v){
        for(Floor floor : floorList){
            return floor.getSpace(v);
        }
        return null;
    }

    public String getpLotId(){
        return pLotId;
    }

    public void setpLotId(String pLotId) {
        this.pLotId = pLotId;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public List<EntryGate> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryGate> entries) {
        this.entries = entries;
    }

    public List<ExitGate> getExits() {
        return exits;
    }

    public void setExits(List<ExitGate> exits) {
        this.exits = exits;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ParkingStrategy getpStrategy() {
        return pStrategy;
    }

    public void setpStrategy(ParkingStrategy pStrategy) {
        this.pStrategy = pStrategy;
    }

    public static ParkingLot getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(ParkingLot iNSTANCE) {
        INSTANCE = iNSTANCE;
    }

    

}
