package algorithm;

import model.Direction;

public class PendingRequests {
    private int floor;
    private Direction dir;

    public  PendingRequests(int floor, Direction dir)
    {
        this.floor= floor;
        this.dir= dir;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDir() {
        return dir;
    }
    

}
