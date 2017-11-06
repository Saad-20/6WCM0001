package CustomerComplaintsSystemAssignment;
import java.util.*;

public class Complaint extends Submission {

    private ArrayList<Action> actions;
    private Staff resolver;
    private Date deadline;
    boolean resolved;

    public Complaint(int id, Customer customer, String description, Date date) {
        super(id, customer, description, date);
    }

    public void recordAction(Action action){
        actions.add(action);
    }

    void setResolver(Staff staff, Date deadline){
        this.resolver = staff;
        this.deadline = deadline;
    }

    Staff getResolver(){
        return resolver;
    }

    public List<Action> getActions(){
        return actions;
    }

    void complaintResolved(){
        resolved = true;
    }
}
