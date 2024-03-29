package model;

import dispatcher.ExternalDispatcher;


public class ExternalButton extends Button{
    private ExternalDispatcher edispatcher = ExternalDispatcher.INSTANCE;
    private Direction direction;

    public void pressButton(int floor, Direction dir){
        direction = dir;
        System.out.println("Pressed " + direction + " from floor " + floor);
        edispatcher.submitRequest(floor, dir);
    }

    public ExternalDispatcher getEdispatcher(){
        return edispatcher;
    }
    public Direction getDirection(){
        return direction;
    }

}
