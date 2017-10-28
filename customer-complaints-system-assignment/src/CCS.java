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
     *
     * @param submissionId
     * @param customerId
     * @param description
     * @param date
     */
    void addGeneralComplaint(int submissionId, int customerId, String description, Date date);

    /**
     *
     * @param submissionId
     * @param customerId
     * @param description
     * @param lift
     * @param floor
     * @param date
     */
    void addLiftComplaint(int submissionId, int customerId, String description, String lift, int floor, Date date);

    /**
     *
     * @param staffId
     * @param name
     * @param role
     * @param department
     */
    void addStaff(int staffId, String name, String role, String department);

    /**
     *
     * @param submissionId
     * @param customerId
     * @param description
     * @param staffId
     * @param date
     */
    void addStaffComplaint(int submissionId, int customerId, String description, int staffId, Date date);

    /**
     * Archive submissions
     */
    void archiveSubmissions();

    /**
     *
     * @param complaintId
     * @param staffId
     * @param deadline
     */
    void assignResolver(int complaintId, int staffId, Date deadline);

    /**
     *
     * @param complaintId
     * @return
     */
    List<Action> getActionsForComplaint(int complaintId);

    /**
     *
     * @param customerId
     * @return
     */
    Customer getCustomer(int customerId);

    /**
     *
     * @return
     */
    List<Customer> getCustomerList();

    /**
     *
     * @return
     */
    int getNewCustomerId();

    /**
     *
     * @return
     */
    int getNewStaffId();

    /**
     *
     */
    int getNewSubmissionId();

    /**
     *
     * @param staffId
     * @return
     */
    Staff getStaff(int staffId);

    /**
     *
     * @return
     */
    List<Staff> getStaffList();

    /**
     *
     * @param submissionId
     * @return
     */
    Submission getSubmission(int submissionId);

    /**
     *
     * @return
     */
    List<Submission> getSubmissionList();

    /**
     *
     * @param complaintId
     * @param actionTaken
     * @param date
     */
    void recordAction(int complaintId, String actionTaken, Date date);

    /**
     *
     * @param complaintId
     */
    void recordComplaintResolved(int complaintId);

    /**
     *
     * @param customerId
     */
    void removeCustomer(int customerId);
}
