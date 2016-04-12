package domain;

/**
 * Created by maciek on 11/04/16.
 */
public class IndividualCustomer extends Customer {
    private String maidenName = null;                                                   // atrybut opcjonalny

    @Override
    public double countDiscount() {
        if (maidenName != null ) {
            return 0.2;
        }
        else
            return 0.1;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }
}
