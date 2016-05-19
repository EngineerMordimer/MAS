package domain;

/**
 * Created by maciek on 11/04/16.
 */
public class Address {
    String street;
    String city;
    String country = "Polska";
    String code;

    public Address( String street , String city , String code ){
        this.street = street;
        this.city = city;
        this.code = code;
    }

    public Address( String street , String city , String code , String country){
        this.street = street;
        this.city = city;
        this.code = code;
        this.country = country;
    }

    public String toString(){
        return "Adres: ul. " + this.street +", miasto: " + this.city + ", kod pocztowy: " + this.code + ", państwo: " + this.country;
    }
}
