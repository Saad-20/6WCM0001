package CustomerComplaintsSystemAssignment;
public class LiftComplaint extends Complaint {
    private String lift;
    private int floor;

    LiftComplaint(int id, Customer customer, String description, Date date, String lift, int floor) {
        super(id, customer, description, date);
        this.lift = lift;
        this.floor = floor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LIFT COMPLAINT\n");
        sb.append(super.toString());
        sb.append(", Lift: " + lift);
        sb.append(", Floor: " + floor);
        return sb.toString();
    }
}
