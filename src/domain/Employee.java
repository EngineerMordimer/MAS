package domain;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by maciek on 20/05/16.
 */
public class Employee extends Person {

    private String login;
    private Workstation workstation;

    private ArrayList<CaseEmployee> caseEmployee = new ArrayList<CaseEmployee>();

    public Employee(){
        super();
    }
    public Employee(String login , String name , String surname){
        super(name,surname);
        this.setLogin(login);
    }

    public Employee(String login , String name , String surname , Workstation workstation){
        this(login,name,surname);
        this.setWorkstation(workstation);
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public Workstation getWorkstation() {
        return workstation;
    }

    public void setWorkstation(Workstation workstation) {

        if ( this.workstation == null ){
            this.workstation = workstation;
            workstation.addEmployee(this);
        }
    }

    public void addCase(LegalCase legalCase , Date beginDate){
        CaseEmployee tempCaseEmployee = new CaseEmployee(legalCase , this , beginDate);

        if( !caseEmployee.contains( tempCaseEmployee ) ){
            caseEmployee.add(tempCaseEmployee);
            legalCase.addEmployee(this , beginDate);
        }
    }


    @Override
    public String toString(){
        String info = "Pracownik: "+ this.getLogin()+ " prowadzi następujące sprawy: ";
        for (CaseEmployee ce : caseEmployee){
            info += "\n    " + ce.getLegalCase().getName() + ", od dnia: " + ce.getBeginDate();
        }
        return info;
    }

    public String showWorkstation(){
        return this.workstation.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return login.equals(employee.login);
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }
}
