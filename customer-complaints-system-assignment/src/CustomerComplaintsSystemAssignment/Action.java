package CustomerComplaintsSystemAssignment;

/**
 * A class representing actions to be linked to complaints (Task 4)
 */
public class Action {
    private String action;
    private Date date;

    /**
     * The constructor for the Action class
     * @param action the description of the action
     * @param date the due date
     */
    public Action(String action, Date date) {
        this.action = action;
        this.date = date;
    }

    /**
     * Get the action's text
     * @return the action's description
     */
    public String getAction() {
        return action;
    }

    /**
     * the due date of the action
     * @return the due date
     */
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Action: " + action +", Date: "+ date.toString();
    }
}
