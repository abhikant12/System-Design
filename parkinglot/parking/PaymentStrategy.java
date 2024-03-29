package parking;

import vehicle.Vehicle;


public abstract class PaymentStrategy {

    private double bikeCharges;
    private double carCharges;
    private double truckCharges;
    public abstract double calculateCost(Ticket t);
    protected double getChargeType(Vehicle v){
        switch (v.getvType()){
            case CAR :
                return carCharges;
            case BIKE:
                return bikeCharges;
            case TRUCK:
                    return truckCharges;


        }

        return 0;

    }
    public double getBikeCharges() {
        return bikeCharges;
    }
    public double getCarCharges() {
        return carCharges;
    }
    public double getTruckCharges() {
        return truckCharges;
    }
    public void setBikeCharges(double bikeCharges) {
        this.bikeCharges = bikeCharges;
    }
    public void setCarCharges(double carCharges) {
        this.carCharges = carCharges;
    }
    public void setTruckCharges(double truckCharges) {
        this.truckCharges = truckCharges;
    }

    
}
