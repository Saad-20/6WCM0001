package CollectionTools;

import java.util.*;

public class MapToCollection<K, V> {

    private Map<K, V> map;

    public MapToCollection(Map<K, V> map) {
        this.map = map;
    }

    //generic functions
    //generic function to create a list of values from a map
    public List<V> getList(){
        return new ArrayList<>(map.values());
    }

    public Set<V> getSet(){
        return new HashSet<>(map.values());
    }

    //generic function to return a sorted list from a map
    //takes a Map<V> and a comparator that implements Comparator<V> and sorts on it
    public List<V> getSortedList(Comparator<? super V> c){
        List<V> list = getList();
        //sort list on comparator c
        list.sort(c);
        return list;
    }

    //generic function to return a list of subclasses from a map
    public <N extends V> List<N> getListOfSubclass(Class<N> subclass){
        //wrapping the complaints list in a synchronizedList wrapper so that we can work in parallel \o/
        List<N> list = new ArrayList<>();
        List<N> parallelList = Collections.synchronizedList(list);
        this.map.entrySet().parallelStream().forEach((e -> {
            //As all submissions are in the same map, need to check if it's a Complaint (or one of its subclasses)
            if (subclass.isInstance(e.getValue())) {
                //cast e to Complaint once we know we can!
                N c = subclass.cast(e.getValue());
                parallelList.add(c);
            }
        }));
        return list;
    }

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

    //generic function to return a sorted list of subclasses from a map
    public <N extends V> List<N> getSortedListOfSubclass(Class<N> subclass, Comparator<? super N> c){
        List<N> list = getListOfSubclass(subclass);
        //sort list on comparator c
        list.sort(c);
        return list;
    }


}