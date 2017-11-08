package CustomerComplaintsSystemAssignment;

public abstract class Submission implements ID{
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
        return super.toString();
    }
}
