package domain;

/**
 * Created by maciek on 11/04/16.
 */
public class Company extends Customer {

    private String name;
    private String NIP;
    private String REGON;

    @Override
    double countDiscount() {
        return 0.3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getREGON() {
        return REGON;
    }

    public void setREGON(String REGON) {
        this.REGON = REGON;
    }
}
