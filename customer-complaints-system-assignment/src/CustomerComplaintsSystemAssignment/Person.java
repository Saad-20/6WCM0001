package CustomerComplaintsSystemAssignment;

public abstract class Person implements ID, java.io.Serializable{

    private int id;
    private String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the ID of this person
     * @return the person's ID
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the name of this person
     * @return the person's name
     */
    String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + id + ", Name: " + name);
        return sb.toString();
    }
}
