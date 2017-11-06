package CustomerComplaintsSystemAssignment;
import java.util.concurrent.atomic.AtomicInteger;

//extending "Person" which contains fields shared across staff and customer
public class Staff extends Person {
    //using atomic integer for thread safety and guaranteed operations
    private static AtomicInteger nextId = new AtomicInteger();
    private String department;
    private String role;

    /**
     * Create a new staff member
     * @param id the staff id (can use Staff.getNewId() to generate)
     * @param name the staff member's name
     * @param department the staff member's department
     * @param role the staff member's role
     */
    public Staff(int id, String name, String department, String role) {
        super(id, name);
        this.department = department;
        this.role = role;
    }

    /**
     * Gets the department a staff member works for
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Gets the staff member's role
     * @return the role
     */
    public String getRole() {
        return role;
    }

    // getNewId is static as we don't want to have to create a Staff object to generate an ID
    // we also don't want to have different values for getNewId depending on the object running the method
    /**
     * gets a new Staff ID

     * @return the next available Staff ID
     */
    static int getNewId(){
        //using the getAndIncrement() method of AtomicInteger to ensure thread safety / atomic transactions
        return nextId.getAndIncrement();
    }

}
