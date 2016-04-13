package domain;

abstract class Customer {
    private int id;
    private Address  address;                                                                      // atrybut złożony
    private static double salary = 500;                                                            // atrybut klasowy
    private double discount;                                                                       // atrybut pochodny

    abstract double countDiscount();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static double getSalary() {
        return salary;
    }

    public static void setSalary(double salary) {
        Customer.salary = salary;
    }

    public double getDiscount(){ return countDiscount(); }
}
