package CustomerComplaintsSystemAssignment;
public class Comment extends Submission {
    // currently there are no features of a "comment" that aren't shared with submissions - the IDs are shared.
    // Submission is, however, abstract and we may want to extend comment later so whilst the class is currently just
    // a constructor, we may wish to add things later

    public Comment(int id, Customer customer, String description, Date date) {
        super(id, customer, description, date);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
