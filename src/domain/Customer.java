package domain;

/**
 * Created by maciek on 11/04/16.
 */
abstract class Customer {
    private int id;
    private String[]  address;                                                                      // atrybut złożony
    private static double salary = 500;                                                            // atrybut klasowy


    abstract double countDiscount();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public static double getSalary() {
        return salary;
    }

    public static void setSalary(double salary) {
        Customer.salary = salary;
    }
}
