package CustomerComplaintsSystemAssignment;
import java.util.HashMap;
import java.util.List;

public class CCSImplementation implements CCS{

    private HashMap<Integer, Submission> submissionMap;
    private HashMap<Integer, Customer> customerMap;
    private HashMap<Integer, Staff> staffMap;

    /**
     * Create's a new instance of the Customer Complaints System
     */
    public CCSImplementation() {
    }

    @Override
    public void addComment(int submissionId, int customerId, String comment, Date date) {
        submissionMap.put(submissionId, new Comment(submissionId, customerMap.get(customerId),comment, date ));
    }

    @Override
    public void addCustomer(int customerId, String name, String address, String email, String phone) {
        customerMap.put(customerId, new Customer(customerId, name, address, email, phone));
    }

    @Override
    public void addGeneralComplaint(int submissionId, int customerId, String description, Date date) {

    }

    @Override
    public void addLiftComplaint(int submissionId, int customerId, String description, String lift, int floor, Date date) {

    }

    @Override
    public void addStaff(int staffId, String name, String role, String department) {

    }

    @Override
    public void addStaffComplaint(int submissionId, int customerId, String description, int staffId, Date date) {

    }

    @Override
    public void archiveSubmissions() {

    }

    @Override
    public void assignResolver(int complaintId, int staffId, Date deadline) {

    }

    @Override
    public List<Action> getActionsForComplaint(int complaintId) {
        return null;
    }

    @Override
    public Customer getCustomer(int customerId) {
        return null;
    }

    @Override
    public List<Customer> getCustomerList() {
        return null;
    }

    /**
     * Gets a list of new complaints
     *
     * @return a list of new complaints
     */
    public List<Complaint> getNewComplaints(){
        return null;
    }

    @Override
    public int getNewCustomerId() {
        return 0;
    }

    @Override
    public int getNewStaffId() {
        return 0;
    }

    @Override
    public int getNewSubmissionId() {
        return 0;
    }

    @Override
    public Staff getStaff(int staffId) {
        return null;
    }

    @Override
    public List<Staff> getStaffList() {
        return null;
    }

    @Override
    public Submission getSubmission(int submissionId) {
        return null;
    }

    @Override
    public List<Submission> getSubmissionList() {
        return null;
    }

    @Override
    public void recordAction(int complaintId, String actionTaken, Date date) {

    }


    @Override
    public void recordComplaintResolved(int complaintId) {

    }

    @Override
    public void removeCustomer(int customerId) {

    }
}
