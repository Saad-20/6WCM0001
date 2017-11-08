package CustomerComplaintsSystemAssignment;
import java.util.List;

/**
 * The CCS (Customer Complaints System) interface
 * @author Chris Pritchard
 * @version 0.1
 */
public interface CCS {
    /**
     * Add a comment
     * @param submissionId The submission ID
     * @param customerId The customer ID
     * @param comment The description of the comment
     * @param date The date of the comment
     */
    void addComment(int submissionId, int customerId, String comment, Date date);

    /**
     * Add a new customer
     * @param customerId The customer ID
     * @param name The customer's name
     * @param address The customer's address
     * @param email The customer's email address
     * @param phone The customer's telephone number
     */
    void addCustomer(int customerId, String name, String address, String email, String phone);

    /**
     * Add a general complaint
     * @param submissionId The submission ID
     * @param customerId The customer ID
     * @param description the description of the complaint
     * @param date the date of the occurrence
     */
    void addGeneralComplaint(int submissionId, int customerId, String description, Date date);

    /**
     * Add a lift complaint
     * @param submissionId the submission id
     * @param customerId the customer id
     * @param description the description of the complaint
     * @param lift the lift name
     * @param floor the lift floor
     * @param date tje date of the occurrence
     */
    void addLiftComplaint(int submissionId, int customerId, String description, String lift, int floor, Date date);

    /**
     * Add a new member of staff
     * @param staffId the staff id
     * @param name the staff name
     * @param role the staff role
     * @param department the staff department
     */
    void addStaff(int staffId, String name, String role, String department);

    /**
     * add a staff complaint
     * @param submissionId the submission id
     * @param customerId the customer id
     * @param description the description of the complaint
     * @param staffId the staff id
     * @param date the date of the occurrence
     */
    void addStaffComplaint(int submissionId, int customerId, String description, int staffId, Date date);

    /**
     * Archive submissions
     */
    void archiveSubmissions();

    /**
     * assign or re-assign a Resolver to a complaint
     * @param complaintId the complaint id
     * @param staffId the staff id
     * @param deadline the date for the resolution of the complaint
     */
    void assignResolver(int complaintId, int staffId, Date deadline);

    /**
     * get a list of all actions for a complaint
     * @param complaintId the complaint id
     * @return the actions for the complaint
     */
    List<Action> getActionsForComplaint(int complaintId);

    /**
     * Gets a list of all complaints
     *
     * @return a list of all complaints
     */
    List<Complaint> getComplaintList();

    /**
     * get the customer with the specified id
     * @param customerId the customer id
     * @return the customer
     */
    Customer getCustomer(int customerId);

    /**
     * get a list of customers
     * @return the customers
     */
    List<Customer> getCustomerList();

    /**
     * get an unused customer id
     * @return the unused customer id
     */
    int getNewCustomerId();

    /**
     * get an unused staff id
     * @return the unused staff id
     */
    int getNewStaffId();

    /**
     * get an unused submission id
     * @return the unused submission id
     */
    int getNewSubmissionId();

    /**
     * get the member of staff with the specified id
     * @param staffId the staff id
     * @return the staff member
     */
    Staff getStaff(int staffId);

    /**
     * get a list of staff
     * @return the staff
     */
    List<Staff> getStaffList();

    /**
     * get the submission with the specified id
     * @param submissionId the submission id
     * @return the submission
     */
    Submission getSubmission(int submissionId);

    /**
     * get a list of submissions
     * @return the submission
     */
    List<Submission> getSubmissionList();

    /**
     * record an action to a complaint
     * @param complaintId the complaint id
     * @param actionTaken the action taken
     * @param date the date the action was taken
     */
    void recordAction(int complaintId, String actionTaken, Date date);

    /**
     * record a complaint as resolved
     * @param complaintId the complaint id
     */
    void recordComplaintResolved(int complaintId);

    /**
     * remove an existing customer
     * @param customerId the customer id
     */
    void removeCustomer(int customerId);
}
