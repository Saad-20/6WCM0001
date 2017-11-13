package CustomerComplaintsSystemAssignment;

public class GeneralComplaint extends Complaint {

    public GeneralComplaint(int id, Customer customer, String description, Date date) {
        super(id, customer, description, date);
    }

    @Override
    void archive() {
        StringBuilder sb = new StringBuilder("GENERAL COMPLAINT");
        sb.append(super.ComplaintArchive());
        System.out.print(sb.toString());
    }
}
