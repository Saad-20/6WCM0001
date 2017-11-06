package CustomerComplaintsSystemAssignment;
import java.util.*;

public class CCSImplementation implements CCS{

    //using maps rather than lists or sets as want to be able to access entries by their IDs
    //HashMap seems to have the best performance
    private Map<Integer, Submission> submissionMap;
    private Map<Integer, Customer> customerMap;
    private Map<Integer, Staff> staffMap;

    /**
     * Create's a new instance of the Customer Complaints System
     */
    public CCSImplementation() {
        //initialise the maps - can use HashMap<>() as don't need to re-declare the types
        submissionMap = new HashMap<>();
        customerMap = new HashMap<>();
        staffMap = new HashMap<>();
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
        submissionMap.put(submissionId, new Complaint(submissionId, customerMap.get(customerId), description, date));
    }

    @Override
    public void addLiftComplaint(int submissionId, int customerId, String description, String lift, int floor, Date date) {
        submissionMap.put(submissionId, new LiftComplaint(submissionId, customerMap.get(customerId), description, date, lift, floor));
    }

    @Override
    public void addStaff(int staffId, String name, String role, String department) {
        staffMap.put(staffId, new Staff(staffId, name, department, role));
    }

    @Override
    public void addStaffComplaint(int submissionId, int customerId, String description, int staffId, Date date) {
        submissionMap.put(submissionId, new StaffComplaint(submissionId, customerMap.get(customerId), description, date, staffMap.get(staffId)));
    }

    @Override
    public void archiveSubmissions() {
        //TODO
    }

    @Override
    public void assignResolver(int complaintId, int staffId, Date deadline) {
        Complaint complaint = (Complaint) submissionMap.get(complaintId);
        complaint.setResolver(staffMap.get(staffId), deadline);
    }

    @Override
    public List<Action> getActionsForComplaint(int complaintId) {
        Complaint complaint = (Complaint) submissionMap.get(complaintId);
        return complaint.getActions();
    }

    @Override
    public Customer getCustomer(int customerId) {
        return customerMap.get(customerId);
    }

    @Override
    public List<Customer> getCustomerList() {
        return getListFromMap(customerMap);
    }

    /**
     * Gets a list of new complaints
     *
     * @return a list of new complaints
     */
    public List<Complaint> getNewComplaints(){
        List<Complaint> complaints = new ArrayList<>();
        List<Complaint> parallelComplaints = Collections.synchronizedList(complaints);
        //don't care about order, so stream the map in parallel for performance
        //using the forEach method to allow for this, as opposed to a for or enhanced for loop
        submissionMap.entrySet().parallelStream().forEach((e -> {
            if (e.getValue() instanceof Complaint){
                Complaint c = (Complaint) e.getValue();
                if (c.getResolver() == null){
                    parallelComplaints.add(c);
                }
            }
        })
        );
        return complaints;
    }

    @Override
    public int getNewCustomerId() {
        return Customer.getNewId();
    }

    @Override
    public int getNewStaffId() {
        return Staff.getNewId();
    }

    @Override
    public int getNewSubmissionId() {
        return Submission.getNewId();
    }

    @Override
    public Staff getStaff(int staffId) {
        return staffMap.get(staffId);
    }

    @Override
    public List<Staff> getStaffList() {
        return getListFromMap(staffMap);
    }

    @Override
    public Submission getSubmission(int submissionId) {
        return submissionMap.get(submissionId);
    }

    @Override
    public List<Submission> getSubmissionList() {
        return getListFromMap(submissionMap);
    }

    @Override
    public void recordAction(int complaintId, String actionTaken, Date date) {
        ((Complaint) submissionMap.get(complaintId)).recordAction(new Action(actionTaken, date));
    }


    @Override
    public void recordComplaintResolved(int complaintId) {
        ((Complaint) submissionMap.get(complaintId)).complaintResolved();
    }

    @Override
    public void removeCustomer(int customerId) {

    }

    private <K, E> List<E> getListFromMap(Map<K, E> map){
        List<E> list = new ArrayList<>();
        List<E> parallelList = Collections.synchronizedList(list);
        //don't care about order, so stream the map in parallel for performance
        //using the forEach method to allow for this, as opposed to a for or enhanced for loop
        map.entrySet().parallelStream().forEach(e -> parallelList.add(e.getValue()));
        return list;
    }
}
