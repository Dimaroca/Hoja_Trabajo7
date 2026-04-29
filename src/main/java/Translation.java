/**
 * Represents one dictionary association between an English word and a Spanish word.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class Translation<K extends Comparable<K>, V> implements Comparable<Translation<K, V>> {
    private K key;
    private V value;

    /**
     * Creates a new key-value association.
     *
     * @param key the key of the association
     * @param value the value of the association
     */
    public Translation(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * Updates the value.
     *
     * @param value the new value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Compares two associations using only their keys.
     *
     * @param other the other association
     * @return a negative number, zero, or a positive number
     */
    @Override
    public int compareTo(Translation<K, V> other) {
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
