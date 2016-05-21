package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by maciek on 20/05/16.
 */
public class LegalCase {
    private int id;
    private ArrayList<CaseEmployee> caseEmployee = new ArrayList<CaseEmployee>();
    private Customer customer;

    private String name;
    private String comments;

    private Set<Task> taskSet = new HashSet<Task>();
    private static Set<Task> allTaskSet = new HashSet<Task>();


    public LegalCase(int id , String name){
        this.setId(id);
        this.setName(name);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public void addEmployee(Employee employee , Date beginDate){
        CaseEmployee tempCaseEmployee = new CaseEmployee( this , employee ,beginDate );

        if( !caseEmployee.contains(tempCaseEmployee) ){
            caseEmployee.add(tempCaseEmployee);
            employee.addCase(this , beginDate);
        }
    }

    public void addTask(Task task) throws Exception{
        if (!taskSet.contains(task)){

            if(allTaskSet.contains(task)){
                throw new Exception("To zadanie jest już powiązane z inną sprawą.");
            }

            taskSet.add(task);
            allTaskSet.add(task);
        }
    }

    @Override
    public String toString(){
        String info = "Sprawa: "+ this.getName()+ " prowadzona jest przez: ";
        for (CaseEmployee ce : caseEmployee){
            info += "\n     " + ce.getEmployee().getLogin() + ", od dnia: " + ce.getBeginDate();
        }
        return info;
    }

    public String showTasks(){
        String info = "Na rzecz sprawy: "+ this.getName()+ " wykonano zadania: ";
        for (Task task : taskSet){
            info += "\n     " + task.getComments() + ", dnia: " + task.getExecutionDate();
        }
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LegalCase legalCase = (LegalCase) o;

        return id == legalCase.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
