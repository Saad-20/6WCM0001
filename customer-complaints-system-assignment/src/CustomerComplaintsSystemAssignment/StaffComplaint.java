package CustomerComplaintsSystemAssignment;
public class StaffComplaint extends Complaint {
    private Staff staff;

    public StaffComplaint(int id, Customer customer, String description, Date date, Staff staff) {
        super(id, customer, description, date);
        this.staff = staff;
    }

    public Staff getStaff(){
        return staff;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
