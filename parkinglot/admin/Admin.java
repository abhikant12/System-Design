package admin;

import parking.*;
import java.util.UUID;


public class Admin {
        private final String id;
        private LoginInfo login;
        private ContactInfo contact;
        
        public Admin(){
            id= UUID.randomUUID().toString();
        }
        //getters and setters
        public String getId(){
            return id;
        }
        public LoginInfo getLogin(){
            return login;
        }
        public void setLogin(LoginInfo login){
            this.login = login;
        }
        public ContactInfo getContact(){
            return contact;
        }
        public void setContact(ContactInfo contact){
            this.contact = contact;
        }

        // admin functions
        public void setParkingStrategy(ParkingStrategy pStrategy){
            ParkingLot.INSTANCE.setpStrategy(pStrategy);
        }
        public void addFloor(Floor f){
            ParkingLot.INSTANCE.getFloorList().add(f);
        }
        public void addParkingSpace(Floor f, ParkingSpace p){
            f.addParkingSpace(p);
        }
        public void addEntryGate(EntryGate entry){
            ParkingLot.INSTANCE.getEntries().add(entry);
        }
        public void addExitGate(ExitGate exit){
            ParkingLot.INSTANCE.getExits().add(exit);
        }

}
