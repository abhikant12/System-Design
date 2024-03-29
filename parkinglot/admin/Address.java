package admin;
 
public class Address{
    private String addressLine1;
    private String city;
    private String state;
    private String country;
    private String pinCode;

    public Address(String addressLine1, String city, String state, String country, String pinCode) {
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }
}
