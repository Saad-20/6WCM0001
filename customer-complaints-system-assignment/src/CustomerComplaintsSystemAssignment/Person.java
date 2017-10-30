package CustomerComplaintsSystemAssignment;

public abstract class Person{

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the ID of this person
     * @return the person's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of this person
     * @return the person's name
     */
    public String getName() {
        return name;
    }

}
