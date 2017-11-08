package CustomerComplaintsSystemAssignment;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * An interface to generate and use IDs
 */

//using Java 8s ability to create static methods in interfaces, as such I don't want code outside the package having access to it
    // as I can't make the nextId field private
    // so using the default (package-private) access level
interface ID{

    //using AtomicInteger so that we don't end up with issues relating to IDs being duplicated
    AtomicInteger nextId = new AtomicInteger();

    /**
     * get this object's ID
     * @return the ID
     */
    int getId();

    /**
     * get the next available Id (and increments the next Id by one)
     * @return the next available Id
     */
    static int getNewId(){
        return nextId.getAndIncrement();
    }
}
