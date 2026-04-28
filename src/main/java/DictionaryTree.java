import java.util.List;

/**
 * Implements an English-Spanish dictionary using a Binary Search Tree.
 */
public class DictionaryTree implements DictionaryInterface<String, String> {
    private BinaryTree<Translation<String, String>> tree;

    /**
     * Creates an empty dictionary.
     */
    public DictionaryTree() {
        tree = new BinaryTree<>();
    }

    /**
     * Inserts or updates a word translation.
     *
     * @param key the English word
     * @param value the Spanish translation
     */
    @Override
    public void put(String key, String value) {
        String normalizedKey = normalize(key);
        tree.insert(new Translation<>(normalizedKey, value.trim()));
    }

    /**
     * Gets the Spanish translation of an English word.
     *
     * @param key the English word
     * @return the Spanish translation, or null if it does not exist
     */
    @Override
    public String get(String key) {
        Translation<String, String> result = tree.search(new Translation<>(normalize(key), ""));
        return result == null ? null : result.getValue();
    }

    /**
     * Checks whether an English word exists in the dictionary.
     *
     * @param key the English word
     * @return true if the word exists, false otherwise
     */
    @Override
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    /**
     * Gets the associations ordered by English word.
     *
     * @return the ordered associations
     */
    public List<Translation<String, String>> inOrder() {
        return tree.inOrder();
    }

    private String normalize(String word) {
        return word.trim().toLowerCase();
    }
}
