package CollectionTools;

import java.util.*;

/**
 * A class that takes a collection and outputs another collection
 * (e.g. set to list or the other way around)
 * @param <E> the type of object the collection takes
 */
public class CollectionToCollection<E> {
    private Collection<E> collection;

    /**
     * The constructor for the CollectionToCollection class
     * @param collection the collection this object operates on
     */
    public CollectionToCollection(Collection<E> collection) {
        this.collection = collection;
    }

    /**
     * gets a list from a collection
     * @return an ArrayList containing all the objects from collections (unsorted)
     */
    public List<E> getList(){
        List<E> list = new ArrayList();
        list.addAll(collection);
        return list;
    }

    /**
     * gets a sorted list from a collection
     * @param c the comparator to sort the collection on
     * @return an ArrayList containing all the objects from the collection (sorted by the comparator)
     */
    public List<E> getSortedList(Comparator<? super E> c){
        List<E> list = getList();
        //sort list on comparator c
        list.sort(c);
        return list;
    }

    /**
     * gets a set from a collection
     * @return a HashSet containing all the objects from the collection
     */
    public Set<E> getSet(){
        Set<E> set = new HashSet<>();
        set.addAll(collection);
        return set;
    }


    /**
     * Gets a list containing all objects of a subclass from the collection
     * @param subclass the subclass of the objects to be returned
     * @param <N> the subclass
     * @return an ArrayList containing objects of a subclass from the collection
     */
    public <N extends E> List<N> getListOfSubclass(Class<N> subclass){
        List<N> list = new ArrayList<>();
        List<N> parallelList = Collections.synchronizedList(list);
        this.collection.parallelStream().forEach((e -> {

            if (subclass.isInstance(e)) {

                N c = subclass.cast(e);
                parallelList.add(c);
            }
        }));
        return list;
    }

    /**
     * Gets a set containing all objects of a subclass from the collection
     * @param subclass the subclass of the objects to be returned
     * @param <N> the subclass
     * @return a HashSet containing objects of a subclass from the collection
     */
    public <N extends E> Set<N> getSetOfSubclass(Class<N> subclass){
        Set<N> set = new HashSet<>();
        Set<N> parallelSet = Collections.synchronizedSet(set);
        this.collection.parallelStream().forEach((e -> {
            if (subclass.isInstance(e)){
                N c = subclass.cast(e);
                parallelSet.add(c);
            }
        }));
        return set;
    }

    /**
     * Gets a sorted list containing all objects of a subclass from the collection
     * @param subclass the subclass of the objects to be returned
     * @param c the comparator to sort on
     * @param <N> the subclass
     * @return an ArrayList containing objects of a subclass from the collection sorted on comparator c
     */
    public <N extends E> List<N> getSortedListOfSubclass(Class<N> subclass, Comparator<? super N> c){
        List<N> list = getListOfSubclass(subclass);
        //sort list on comparator c
        list.sort(c);
        return list;
    }
}
