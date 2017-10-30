package CustomerComplaintsSystemAssignment;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer extends Person {
    // Using the AtomicInteger class to store nextID as it has thread safe methods and is therefore better for an ID than a plain int
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
     * Gets the customer's address
     * @return the customer's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the customer's email
     * @return the customer's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the customer's telephone number
     * @return the customer's telephone number
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * gets a new Customer ID
     * @return the next available customer ID
     */
    public static int getNewId() {
        return nextId.getAndIncrement();
    }
}
