package CustomerComplaintsSystemAssignment;
import java.util.*;

/**
 *
 */
public abstract class Complaint extends Submission {

    private List<Action> actions;
    private Staff resolver;
    private Date deadline;
    private boolean resolved;

    /**
     *
     * @param id
     * @param customer
     * @param description
     * @param date
     */
    Complaint(int id, Customer customer, String description, Date date) {
        super(id, customer, description, date);
        actions = new ArrayList<>();
    }

    /**
     *
     * @param action
     */
    void recordAction(Action action){
        actions.add(action);
    }

    /**
     *
     * @param staff
     * @param deadline
     */
    void setResolver(Staff staff, Date deadline){
        this.resolver = staff;
        this.deadline = deadline;
    }

    /**
     *
     * @return
     */
    Staff getResolver(){
        return resolver;
    }

    /**
     *
     * @return
     */
    public List<Action> getActions(){
        return actions;
    }

    /**
     *
     */
    void complaintResolved(){
        resolved = true;
    }

    @Override
    public String toString() {
        String submissionString = super.toString() + "\n";
        String complaintString = "Resolver:" + resolver.toString() + "\n";
        String actionsString = "Actions:" + actionsString() + "\n";
        String isResolved = "Resolved: " + resolved;
        return submissionString + complaintString + actionsString + isResolved;
    }

    /**
     * Checks to see if the complaint is linked to a valid customer
     * @throws CustomerNotFoundException if the customer does not exist in the CCS
     * @param ccs the ccs implementation to check against
     */
    public void validateCustomer(CCS ccs) throws CustomerNotFoundException{
        if(ccs.getCustomerList().contains(super.getCustomer())){
            return;
        }
        else throw new CustomerNotFoundException(super.getCustomer().toString());
    }

    /**
     *
     * @return
     */
    private String actionsString(){
        StringBuilder sb = new StringBuilder("\n");
        actions.forEach(e -> sb.append(e.toString() + "\n"));
        return sb.toString();
    }

    @Override
    boolean isArchivable(){
        return resolved;
    }

    /**
     *
     * @return
     */
    String ComplaintArchive() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.customerArchive());
        sb.append("NATURE COMPLAINT: " + super.getDescription() + "\n");
        sb.append("DATE OF COMPLAINT: " + super.getDate().toString() + "\n");
        return sb.toString();
    }
}
