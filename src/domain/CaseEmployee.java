package domain;

import java.util.Date;

/**
 * Created by maciek on 20/05/16.
 */
public class CaseEmployee {
    private LegalCase legalCase;
    private Employee employee;

    private Date beginDate;
    private Date endDate;

    public CaseEmployee(){

    }

    public CaseEmployee(LegalCase legalCase , Employee employee){
        this.legalCase = legalCase;
        this.employee = employee;
    }
    public CaseEmployee(LegalCase legalCase , Employee employee , Date beginDate){
        this.legalCase = legalCase;
        this.employee = employee;
        this.beginDate = beginDate;
    }

    public LegalCase getLegalCase() {
        return legalCase;
    }

    public void setLegalCase(LegalCase legalCase) {
        this.legalCase = legalCase;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseEmployee that = (CaseEmployee) o;

        if (!legalCase.equals(that.legalCase)) return false;
        return employee.equals(that.employee);

    }

    @Override
    public int hashCode() {
        int result = legalCase.hashCode();
        result = 31 * result + employee.hashCode();
        return result;
    }
}
