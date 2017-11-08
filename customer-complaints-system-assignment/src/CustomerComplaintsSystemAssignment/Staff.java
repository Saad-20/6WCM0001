package CustomerComplaintsSystemAssignment;


//extending "Person" which contains fields shared across staff and customer
public class Staff extends Person {
    private String department;
    private String role;

    /**
     * Create a new staff member
     * @param id the staff id (can use Staff.getNewId() to generate)
     * @param name the staff member's name
     * @param department the staff member's department
     * @param role the staff member's role
     */
    Staff(int id, String name, String department, String role) {
        super(id, name);
        this.department = department;
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
