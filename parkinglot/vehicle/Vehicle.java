package vehicle;


public abstract class Vehicle {
    private String regNum;
    private VehicleType vType;


    public Vehicle(String regNum, VehicleType vType){
        this.regNum= regNum;
        this.vType= vType;
    }
    public String getRegNum() {
        return regNum;
    }
    public VehicleType getvType() {
        return vType;
    }
}
