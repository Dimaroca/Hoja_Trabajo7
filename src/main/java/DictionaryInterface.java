/**
 * Defines the basic operations for a key-value dictionary.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public interface DictionaryInterface<K, V> {

    /**
     * Inserts or updates a key-value pair.
     *
     * @param key the key used to identify the value
     * @param value the value associated with the key
     */
    void put(K key, V value);

    /**
     * Searches for a value by key.
     *
     * @param key the key to search
     * @return the associated value, or null if the key does not exist
     */
    V get(K key);

    /**
     * Checks whether a key exists in the dictionary.
     *
     * @param key the key to search
     * @return true if the key exists, false otherwise
     */
    boolean containsKey(K key);
}
