package CollectionTools;

import java.util.*;

/**
 * A class to turn Maps to Collections (lists/sets)
 * @param <K> The key from the map
 * @param <V> The value stored in the map
 */
public class MapToCollection<K, V> {

    private Map<K, V> map;

    /**
     * The constructor for the MapToCollection class
     * @param map the map this object will operate on
     */
    public MapToCollection(Map<K, V> map) {
        this.map = map;
    }

    //generic functions
    //generic function to create a list of values from a map

    /**
     * Gets a list of values from the map
     * @return an ArrayList containing the map values
     */
    public List<V> getList(){
        return new ArrayList<>(map.values());
    }

    /**
     * Gets a set of values from the map
     * @return a HashSet containing the map values
     */
    public Set<V> getSet(){
        return new HashSet<>(map.values());
    }

    //generic function to return a sorted list from a map
    //takes a Map<V> and a comparator that implements Comparator<V> and sorts on it

    /**
     * gets a sorted list of values from the map
     * @param c the comparator to sort against
     * @return a list of values sorted by comparator c
     */
    public List<V> getSortedList(Comparator<? super V> c){
        List<V> list = getList();
        //sort list on comparator c
        list.sort(c);
        return list;
    }

    /**
     * Get a list of subclasses from the map
     * @param subclass the Class object of the subclass to filter against
     * @param <N> the subclass to filter against
     * @return a list containing objects of subclass N from the map
     */
    //generic function to return a list of subclasses from a map
    public <N extends V> List<N> getListOfSubclass(Class<N> subclass){
        //wrapping the list in a synchronizedList wrapper so that we can work in parallel \o/
        List<N> list = new ArrayList<>();
        List<N> parallelList = Collections.synchronizedList(list);
        this.map.entrySet().parallelStream().forEach((e -> {
            //need to check if it's one of the subclasses)
            if (subclass.isInstance(e.getValue())) {
                //cast e to subclass once we know we can!
                N c = subclass.cast(e.getValue());
                parallelList.add(c);
            }
        }));
        return list;
    }

    /**
     * Get a set of subclasses from the map
     * @param subclass the Class object of the subclass to filter against
     * @param <N> the subclass to filter against
     * @return a set containing objects of subclass N from the map
     */
    public <N extends V> Set<N> getSetOfSubclass(Class<N> subclass){
        Set<N> set = new HashSet<>();
        Set<N> parallelSet = Collections.synchronizedSet(set);
        this.map.entrySet().parallelStream().forEach((e -> {
            if (subclass.isInstance(e.getValue())){
                N c = subclass.cast(e.getValue());
                parallelSet.add(c);
            }
        }));
        return set;
    }

    /**
     * Get a sorted list of subclasses from the map
     * @param subclass the Class object of the subclass to filter against
     * @param <N> the subclass to filter against
     * @param c the comparator to sort against
     * @return a list containing objects of subclass N from the map sorted on comparator c
     */
    //generic function to return a sorted list of subclasses from a map
    public <N extends V> List<N> getSortedListOfSubclass(Class<N> subclass, Comparator<? super N> c){
        List<N> list = getListOfSubclass(subclass);
        //sort list on comparator c
        list.sort(c);
        return list;
    }


}