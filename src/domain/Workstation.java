package domain;

import java.util.ArrayList;

/**
 * Created by maciek on 20/05/16.
 */
public class Workstation {

    private Integer roomNumber;
    private int size;
    private Floor floor;

    private ArrayList<Employee> employeeList = new ArrayList<>();

    public Workstation (int roomNumber , int size){
        this.setRoomNumber(roomNumber);
        this.setSize(size);
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        if (!employeeList.contains(employee)){
            this.employeeList.add(employee);
            employee.setWorkstation(this);
        }
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor){
        if (this.floor == null) {
            this.floor = floor;
            floor.addWorkstation(this);
        }
    }

    public String toString(){
        String info = "Pokój nr: " + this.getRoomNumber() + ", o rozmiarze: " + this.getSize() + " m2";
        if (this.getFloor() != null) {
            info += ",na piętrze: " + this.getFloor().getNumber();
        }
        info += ", zajmują: ";
        for (Employee emp : this.getEmployeeList()) {
            info += "\n     "+emp.getLogin();
        }
        return info;
    }
}
