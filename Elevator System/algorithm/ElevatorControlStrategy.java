package algorithm;
import model.ElevatorController;
import model.ElevatorSystem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ElevatorControlStrategy {
    //queue storing pending requests in form of
    private Queue<PendingRequests> pendingRequestList= new LinkedList<PendingRequests>();
    private List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();

    public void moveElevator(ElevatorController elevatorController)
    {

    }

    public Queue<PendingRequests> getPendingRequestList() {
        return pendingRequestList;
    }

    public void setPendingRequestList(Queue<PendingRequests> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }
    
}
