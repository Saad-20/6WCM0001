package CustomerComplaintsSystemAssignment;

import java.util.Comparator;

/**
 * A Comparator for classes that implement the ID interface
 */
class IdComparator implements Comparator<ID> {


    @Override
    public int compare(ID o1, ID o2) {
         return o1.getId() - o2.getId();
    }

}
