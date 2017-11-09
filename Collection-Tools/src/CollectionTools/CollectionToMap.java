package CollectionTools;

import java.util.*;

public class CollectionToMap<K, V extends Keys<K>>  {

    private Collection<V> collection;

    public CollectionToMap(Collection<V> collection) {
        this.collection = collection;
    }

    public Map<K, V> getMap(){
        Map<K,V> map = new HashMap<>();
        Map<K,V> parallelMap = Collections.synchronizedMap(map);
        collection.parallelStream().forEach(e -> {
            parallelMap.put(e.getKey(), e);
        });
        return map;
    }

    public <N extends V> Map<K,N> getMapOfSubclass(Class<N> subclass){
        //wrapping the complaints list in a synchronizedList wrapper so that we can work in parallel \o/
        Map<K, N> map = new HashMap<>();
        Map<K, N> parallelMap = Collections.synchronizedMap(map);
        this.collection.parallelStream().forEach((e -> {
            //As all submissions are in the same map, need to check if it's a Complaint (or one of its subclasses)
            if (subclass.isInstance(e)) {
                //cast e to Complaint once we know we can!
                N c = subclass.cast(e);
                parallelMap.put(c.getKey(), c);
            }
        }));
        return map;
    }
}
