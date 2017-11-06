package CustomerComplaintsSystemAssignment;
public class LiftComplaint extends Complaint {
    private String lift;
    private int floor;

    public LiftComplaint(int id, Customer customer, String description, Date date, String lift, int floor) {
        super(id, customer, description, date);
        this.lift = lift;
        this.floor = floor;
    }
}
