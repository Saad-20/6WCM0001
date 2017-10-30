package CustomerComplaintsSystemAssignment;


import java.util.HashSet;

public class Complaint extends Submission {

    private HashSet<Action> actions;

    public Complaint(int id, Customer customer, String description, Date date) {
        super(id, customer, description, date);
    }

    public void recordAction(Action action){
        actions.add(action);
    }
}
