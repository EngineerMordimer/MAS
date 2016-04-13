package domain;

/**
 * Created by maciek on 11/04/16.
 */
public class IndividualCustomer extends Customer {
    private String maidenName = null;                                                   // atrybut opcjonalny
    private Person person;

    public IndividualCustomer(Person person){
        this.setPerson(person);
    }
    //przesłanianie
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

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }

    public String toString(){
        return this.getPerson().toString() + " nazwisko panieńskie: " + this.getMaidenName();
    }
}
