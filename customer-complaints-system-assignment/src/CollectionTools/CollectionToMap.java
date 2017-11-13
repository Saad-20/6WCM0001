package CollectionTools;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A method to turn collections (lists and sets) into maps
 * @param <K> the class used as a key
 * @param <V> the class used as a value
 */
public class CollectionToMap<K, V extends Keys<K>>  {

    private Collection<V> collection;

    /**
     * The constructor for the CollectionToMapClass
     * @param collection the collection to be used
     */
    public CollectionToMap(Collection<V> collection) {
        this.collection = collection;
    }

    /**
     * gets a map from the collection
     * @return a map from the collection, uses the getKey method from the Keys interface to get the keys
     */
    public Map<K, V> getMap(){
        Map<K,V> map = new HashMap<>();
        Map<K,V> parallelMap = Collections.synchronizedMap(map);
        collection.parallelStream().forEach(e -> {
            parallelMap.put(e.getKey(), e);
        });
        return map;
    }

    /**
     * Gets a map containing all objects of a subclass from the collection
     * @param subclass the subclass of the objects to be returned
     * @param <N> the subclass
     * @return a HashMap containing objects of a subclass from the collection, uses the getKey method to get the keys
     */
    public <N extends V> Map<K,N> getMapOfSubclass(Class<N> subclass){
        //wrapping the list in a synchronizedList wrapper so that we can work in parallel \o/
        Map<K, N> map = new HashMap<>();
        Map<K, N> parallelMap = Collections.synchronizedMap(map);
        this.collection.parallelStream().forEach((e -> {
            //check if subclass
            if (subclass.isInstance(e)) {
                //cast e to subclass once we know we can!
                N c = subclass.cast(e);
                parallelMap.put(c.getKey(), c);
            }
        }));
        return map;
    }
}
