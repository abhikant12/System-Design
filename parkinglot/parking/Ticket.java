package parking;

import java.time.LocalDateTime;
import java.util.UUID;
import vehicle.Vehicle;


public class Ticket{
    private final String ticketId;
    private final LocalDateTime entryTime;
    private final Vehicle vehicle;
    private final ParkingSpace pSpaceAssigned;
    private LocalDateTime exitTime;
    private boolean isActive;
    private double charges;

    public Ticket(Vehicle v, ParkingSpace pSpace){
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = LocalDateTime.now();
        this.isActive = true;
        this.vehicle = v;
        this.pSpaceAssigned = pSpace;
    }

    // getters and setters;
    public String getTicketId(){
        return ticketId;
    }

    public LocalDateTime getEntryTime(){
        return entryTime;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public ParkingSpace getpSpaceAssigned(){
        return pSpaceAssigned;
    }

    public LocalDateTime getExitTime(){
        return exitTime;
    }

    public boolean isActive(){
        return isActive;
    }

    public double getCharges(){
        return charges;
    }

    public void setExitTime(LocalDateTime exitTime){
        this.exitTime = exitTime;
    }

    public void setActive(boolean isActive){
        this.isActive = isActive;
    }

    public void setCharges(double charges){
        this.charges = charges;
    }

}
