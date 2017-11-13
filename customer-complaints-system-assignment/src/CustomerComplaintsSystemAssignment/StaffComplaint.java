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
        StringBuilder sb = new StringBuilder();
        sb.append("Staff: \n");
        sb.append(staff.toString() + "\n");
        sb.append(super.toString());
        return super.toString();
    }

    @Override
    void archive() {
        StringBuilder sb = new StringBuilder("STAFF COMPLAINT");
        sb.append(super.ComplaintArchive());
        sb.append("STAFF NAME: " + staff.getName() + "\n");
        sb.append("STAFF ID: " + staff.getId());
        System.out.println(sb.toString());
    }
}
