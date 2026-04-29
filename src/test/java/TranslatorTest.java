import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests for Translator.
 */
public class TranslatorTest {

    @Test
    public void testTranslationFound() {
        DictionaryTree dict = new DictionaryTree();

        dict.put("dog", "perro");

        Translator translator = new Translator(dict);

        String result = translator.translate("dog");

        assertEquals("perro", result);
    }

    @Test
    public void testTranslationNotFound() {
        DictionaryTree dict = new DictionaryTree();

        Translator translator = new Translator(dict);

        String result = translator.translate("cat");

        assertEquals("*cat*", result);
    }

    @Test
    public void testMixedTranslation() {
        DictionaryTree dict = new DictionaryTree();

        dict.put("dog", "perro");

        Translator translator = new Translator(dict);

        String result = translator.translate("dog cat");

        assertEquals("perro *cat*", result);
    }
}