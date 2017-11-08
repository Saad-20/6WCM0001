package CustomerComplaintsSystemAssignment;

public class Customer extends Person{
    private String address;
    private String email;
    private String telephone;


    Customer(int id, String name, String address, String email, String telephone) {
        super(id, name);
        this.address = address;
        this.email = email;
        this.telephone = telephone;
    }

    /**
     * Gets the customer's address
     * @return the customer's address
     */
    String getAddress() {
        return address;
    }

    /**
     * Gets the customer's email
     * @return the customer's email
     */
    String getEmail() {
        return email;
    }

    /**
     * Gets the customer's telephone number
     * @return the customer's telephone number
     */
    String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
