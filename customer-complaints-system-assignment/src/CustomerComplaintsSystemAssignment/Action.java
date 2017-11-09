package CustomerComplaintsSystemAssignment;
public class Action {
    private String action;
    private Date date;

    public Action(String action, Date date) {
        this.action = action;
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Action: " + action +", Date: "+ date.toString();
    }
}
