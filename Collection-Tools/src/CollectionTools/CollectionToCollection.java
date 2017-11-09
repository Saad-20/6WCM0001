package CollectionTools;

import java.util.*;

public class CollectionToCollection<E> {
    private Collection<E> collection;

    public CollectionToCollection(Collection<E> collection) {
        this.collection = collection;
    }

    public List<E> getList(){
        List<E> list = new ArrayList();
        list.addAll(collection);
        return list;
    }

    public List<E> getSortedList(Comparator<? super E> c){
        List<E> list = getList();
        //sort list on comparator c
        list.sort(c);
        return list;
    }

    public Set<E> getSet(){
        Set<E> set = new HashSet<>();
        set.addAll(collection);
        return set;
    }

    public <N extends E> List<N> getListOfSubclass(Class<N> subclass){
        List<N> list = new ArrayList<>();
        List<N> parallelList = Collections.synchronizedList(list);
        this.collection.parallelStream().forEach((e -> {
            //As all submissions are in the same map, need to check if it's a Complaint (or one of its subclasses)
            if (subclass.isInstance(e)) {
                //cast e to Complaint once we know we can!
                N c = subclass.cast(e);
                parallelList.add(c);
            }
        }));
        return list;
    }

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

    public <N extends E> List<N> getSortedListOfSubclass(Class<N> subclass, Comparator<? super N> c){
        List<N> list = getListOfSubclass(subclass);
        //sort list on comparator c
        list.sort(c);
        return list;
    }
}
