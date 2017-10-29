package CustomerComplaintsSystemAssignment;
import java.util.concurrent.atomic.AtomicInteger;

public class Staff extends Person {
    private static AtomicInteger nextId = new AtomicInteger();
    private String department;
    private String role;

    public Staff(int id, String name, String department, String role) {
        super(id, name);
        this.department = department;
        this.role = role;
    }

    static int getNewId(){
        return nextId.getAndIncrement();
    }

}
