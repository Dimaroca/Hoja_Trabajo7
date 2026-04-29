import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 * Tests for DictionaryTree.
 */
public class DictionaryTreeTest {

    @Test
    public void testPutAndGet() {
        DictionaryTree dict = new DictionaryTree();

        dict.put("house", "casa");

        String result = dict.get("house");

        assertEquals("casa", result);
    }

    @Test
    public void testCaseInsensitive() {
        DictionaryTree dict = new DictionaryTree();

        dict.put("house", "casa");

        String result = dict.get("HOUSE");

        assertEquals("casa", result);
    }

    @Test
    public void testWordNotFound() {
        DictionaryTree dict = new DictionaryTree();

        String result = dict.get("unknown");

        assertNull(result);
    }
}