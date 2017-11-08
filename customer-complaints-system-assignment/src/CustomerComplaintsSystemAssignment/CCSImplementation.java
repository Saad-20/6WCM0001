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
        return getSortedListFromMap(customerMap, new IdComparator());
    }

    /**
     * Gets a list of new complaints
     *
     * @return a list of new complaints
     */
    public List<Complaint> getNewComplaints(){
        //wrapping the complaints list in a synchronizedList wrapper so that we can work in parallel \o/
        List<Complaint> complaints = new ArrayList<>();
        List<Complaint> parallelComplaints = Collections.synchronizedList(complaints);
        submissionMap.entrySet().parallelStream().forEach((e -> {
            //As all submissions are in the same map, need to check if it's a Complaint (or one of its subclasses)
            if (e.getValue() instanceof Complaint){
                //cast e to Complaint once we know we can!
                Complaint c = (Complaint) e.getValue();
                // check if a resolver is assigned, if not add it to the list
                // have to do it this way as we can't just take the map.values() collection
                // as we can below
                if (c.getResolver() == null){
                    parallelComplaints.add(c);
                }
            }
        })
        );
        //Sort the list by Id
        complaints.sort(new IdComparator());
        return complaints;
    }

    @Override
    public int getNewCustomerId() {
        return ID.getNewId();
    }

    @Override
    public int getNewStaffId() {
        return ID.getNewId();
    }

    @Override
    public int getNewSubmissionId() {
        return ID.getNewId();
    }

    @Override
    public Staff getStaff(int staffId) {
        return staffMap.get(staffId);
    }

    @Override
    public List<Staff> getStaffList() {
        return getSortedListFromMap(staffMap, new IdComparator());
    }

    @Override
    public Submission getSubmission(int submissionId) {
        return submissionMap.get(submissionId);
    }

    @Override
    public List<Submission> getSubmissionList() {
        return getSortedListFromMap(submissionMap, new IdComparator());
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
        customerMap.remove(customerId);
    }

    //generic function to create a list of values from a map
    private <K, V> List<V> getListFromMap(Map<K, V> map){
        return new ArrayList<>(map.values());
    }

    //generic function to return a sorted list from a map
    //takes a Map<V> and a comparator that implements Comparator<V> and sorts on it
    private <K, V> List<V> getSortedListFromMap(Map<K, V> map, Comparator<? super V> c){
        List<V> list = getListFromMap(map);
        //sort list on comparator c
        list.sort(c);
        return list;
    }

}
