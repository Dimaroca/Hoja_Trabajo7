import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 * Tests for BinaryTree insert and search.
 */
public class BinaryTreeTest {

    @Test
    public void testInsertAndSearch() {
        BinaryTree<Translation<String, String>> tree = new BinaryTree<>();

        tree.insert(new Translation<>("house", "casa"));
        tree.insert(new Translation<>("dog", "perro"));

        Translation<String, String> result =
                tree.search(new Translation<>("dog", ""));

        assertNotNull(result);
        assertEquals("perro", result.getValue());
    }

    @Test
    public void testSearchNotFound() {
        BinaryTree<Translation<String, String>> tree = new BinaryTree<>();

        tree.insert(new Translation<>("house", "casa"));

        Translation<String, String> result =
                tree.search(new Translation<>("cat", ""));

        assertNull(result);
    }
}