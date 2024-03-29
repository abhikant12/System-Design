package model;

import algorithm.ElevatorControlStrategy;
import algorithm.ElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.List;


public class ElevatorSystem {
    private List<ElevatorController> elevatorControllerList= new ArrayList<ElevatorController>();
    public static ElevatorControlStrategy elevatorControlStrategy;
    public static ElevatorSelectionStrategy elevatorSelectionStrategy;
    public List<Floor> floors= new ArrayList<Floor>();

    public static ElevatorSystem INSTANCE= new ElevatorSystem();

    private ElevatorSystem()
    {

    }

    public void addElevator(ElevatorController e)
    {
        elevatorControllerList.add(e);
    }
    public void removeElevator(ElevatorController e)
    {
        elevatorControllerList.remove(e);
    }
    public void setElevatorControlStrategy(ElevatorControlStrategy elevatorControlStrategy)
    {
        this.elevatorControlStrategy= elevatorControlStrategy;
    }
    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy)
    {
        this.elevatorSelectionStrategy= elevatorSelectionStrategy;
    }
    public  void addFloor(Floor floor)
    {
        floors.add(floor);
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public static ElevatorControlStrategy getElevatorControlStrategy() {
        return elevatorControlStrategy;
    }

    public static ElevatorSelectionStrategy getElevatorSelectionStrategy() {
        return elevatorSelectionStrategy;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public static ElevatorSystem getINSTANCE() {
        return INSTANCE;
    }

    

}
