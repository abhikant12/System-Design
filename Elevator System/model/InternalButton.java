package model;

import dispatcher.InternalDispatcher;

import java.util.ArrayList;
import java.util.List;

public class InternalButton extends  Button{
    private InternalDispatcher idispatcher;
    private List<Integer> floors= new ArrayList<Integer>();

    public InternalButton(){
        idispatcher = new InternalDispatcher();
    }

    public void pressButton(int floor, Direction dir, int elevatorId){
        floors.add(floor);
        System.out.println("Pressed floor "+ floor + " from elevator "+ elevatorId);
        idispatcher.submitRequest(floor, dir, elevatorId);
    }

    public InternalDispatcher getIdispatcher() {
        return idispatcher;
    }

    public List<Integer> getFloors() {
        return floors;
    }

    
}
