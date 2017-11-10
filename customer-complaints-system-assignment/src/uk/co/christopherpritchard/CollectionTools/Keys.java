package uk.co.christopherpritchard.CollectionTools;

/**
 * An interface a class must implement to be able to convert from a map to a collection
 * @param <K> the type that is returned by the getKey() method
 */
public interface Keys<K> {
    /**
     * A method to get a key from an object
     * @return the key (to be used within a map)
     */
    K getKey();
}
