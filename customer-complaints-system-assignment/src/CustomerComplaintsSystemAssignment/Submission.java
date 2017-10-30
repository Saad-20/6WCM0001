package CustomerComplaintsSystemAssignment;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Submission {
    private static AtomicInteger nextId = new AtomicInteger();
    private int id;
    private Customer customer;
    private String description;
    private Date date;

    public Submission(int id, Customer customer, String description, Date date) {
        this.id = id;
        this.customer = customer;
        this.description = description;
        this.date = date;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @return
     */
    public static int getNewId(){
        return nextId.getAndIncrement();
    }
}
