package CustomerComplaintsSystemAssignment;

/**
 * The comment class (task 4)
 */
public class Comment extends Submission {
    // currently there are no features of a "comment" that aren't shared with submissions - the IDs are shared.
    // Submission is, however, abstract and we may want to extend comment later so whilst the class is currently just
    // a constructor, we may wish to add things later

    /**
     * The constructor for a comment
     * @param id the ID of the comment
     * @param customer a Customer object representing the customer who made the comment
     * @param description the text of the comment
     * @param date the date the comment was made
     */
    public Comment(int id, Customer customer, String description, Date date) {
        super(id, customer, description, date);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Archive the comment as per the spec - currently this just prints out to the terminal window
     */
    @Override
    void archive() {
        StringBuilder sb = new StringBuilder("COMMENT");
        sb.append(super.customerArchive());
        sb.append("COMMENT: " + super.getDescription() + "\n");
        sb.append("DATE OF COMMENT: " + super.getDate().toString() + "\n");
        System.out.print(sb.toString());
    }
}
