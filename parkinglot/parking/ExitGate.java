package parking;

import java.time.LocalDateTime;

public class ExitGate{
    String gateId;

    public ExitGate(String gateId){
        this.gateId = gateId;
    }

    public Payment makePayment(PaymentType pType, PaymentStrategy pStrategy, Ticket ticket){

        ticket.setExitTime(LocalDateTime.now());
        double cost = pStrategy.calculateCost(ticket);
        ticket.setCharges(cost);

        Payment p = new Payment(cost, ticket, pStrategy);
        p.makePayment(pType);
        ticket.setActive(false);

        freeParkingSpace(ticket.getpSpaceAssigned());
        return p;
    }

    private void freeParkingSpace(ParkingSpace pSpace){
        pSpace.removeVehicle();
    }

    // getters;
    public String getGateId(){
        return gateId;
    }

}
