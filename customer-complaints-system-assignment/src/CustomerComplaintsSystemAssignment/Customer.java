package CustomerComplaintsSystemAssignment;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer extends Person {
    // Using the AtomicInteger class to store nextID as it's thread safe and less likely to cause issues down the line

    private static AtomicInteger nextId = new AtomicInteger();
    private String address;
    private String email;
    private String telephone;


    public Customer(int id, String name, String address, String email, String telephone) {
        super(id, name);
        this.address = address;
        this.email = email;
        this.telephone = telephone;
    }

    /**
     * gets a new Customer ID
     * @return the next available customer ID
     */
    public static int getNewId() {
        return nextId.getAndIncrement();
    }
}
