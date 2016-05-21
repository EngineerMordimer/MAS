package domain;

import java.util.Date;

/**
 * Created by maciek on 20/05/16.
 */
public class Task {

    private LegalCase legalCase;
    private Date executionDate;
    private String comments;

    private Task(){
    }

    private Task(LegalCase legalCase , Date executionDate , String comments){
        this.legalCase = legalCase;
        this.executionDate = executionDate;
        this.comments = comments;
    }

    public Date getExecutionDate() {
        return executionDate;
    }
    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }


    public static Task createTask(LegalCase legalCase ,  Date executionDate , String comments) throws Exception {
        if (legalCase == null){
            throw new Exception("Brak sprawy");
        }

        Task task = new Task(legalCase , executionDate , comments);

        legalCase.addTask(task);
        return task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!legalCase.equals(task.legalCase)) return false;
        if (!executionDate.equals(task.executionDate)) return false;
        return comments.equals(task.comments);

    }

    @Override
    public int hashCode() {
        int result = legalCase.hashCode();
        result = 31 * result + executionDate.hashCode();
        result = 31 * result + comments.hashCode();
        return result;
    }
}
