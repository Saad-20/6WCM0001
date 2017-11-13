package CustomerComplaintsSystemAssignment;

public abstract class Submission implements ID, java.io.Serializable{
    private int id;
    private Customer customer;
    private String description;
    private Date date;

    Submission(int id, Customer customer, String description, Date date) {
        this.id = id;
        this.customer = customer;
        this.description = description;
        this.date = date;
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @return
     */
    String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + this.id + ", Description: " + description + ", Date: " + date.toString() + ", Customer: " + customer.toString());
        return sb.toString();
    }

    protected String customerArchive(){
        StringBuilder sb = new StringBuilder();
        sb.append("CUSTOMER NAME: " + customer.getName() + "\n");
        sb.append("CUSTOMER ADDRESS: " + customer.getAddress() + "\n");
        sb.append("CUSTOMER EMAIL: " + customer.getEmail() + "\n");
        sb.append("CUSTOMER PHONE NO: " + customer.getTelephone() + "\n");
        return sb.toString();
    }
    /**
     * Archives the object, if it's eligible for archiving
     */
    abstract void archive();

    boolean isArchivable(){
        return true;
    }
}
