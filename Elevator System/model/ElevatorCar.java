package model;


public class ElevatorCar {
    private int id;
    private Door door;
    private Display display;
    private Button button;
    private int currentFloor;  //updated while elevator moves to each floor
    private Direction dir; //updated every time elevator hanges direction


    public ElevatorCar(int id){
        this.id= id;
        door= new Door();
        display= new Display();
        currentFloor= 0;
        dir= Direction.NONE;
        button= new InternalButton();
    }

    public void move(Direction dir, int floor){
        System.out.println("Elevator " + id + "moving " + dir);
        System.out.println("Elevator " + id + "stops at floor " + floor);
        door.open(id);
        door.close(id);
         
        setDisplay();                      //called everytime when currFloor value changes
    }

    public void pressButton(int floor){
        Direction dir = Direction.NONE;
        if(floor > currentFloor) dir = Direction.UP;
        else if(floor < currentFloor) dir = Direction.DOWN;
        
        button.pressButton(floor, dir, id);
    }

 
    // getters and setters;
    private void setDisplay(){
        display.setFloor(currentFloor);
        display.setDir(dir);
    }

    public int getId() {
        return id;
    }

    public Door getDoor() {
        return door;
    }

    public Display getDisplay() {
        return display;
    }

    public Button getButton() {
        return button;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDir() {
        return dir;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }


}
