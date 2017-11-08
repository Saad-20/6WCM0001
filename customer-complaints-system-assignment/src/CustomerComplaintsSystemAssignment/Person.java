package CustomerComplaintsSystemAssignment;

public abstract class Person implements ID{

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
        return super.toString();
    }
}
