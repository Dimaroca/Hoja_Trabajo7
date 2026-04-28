/**
 * Translates an English text into Spanish using a dictionary.
 */
public class Translator {
    private DictionaryTree dictionary;

    /**
     * Creates a translator.
     *
     * @param dictionary the dictionary used for translation
     */
    public Translator(DictionaryTree dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Translates a text word by word. Unknown words are written between asterisks.
     *
     * @param text the original English text
     * @return the translated text
     */
    public String translate(String text) {
        String[] tokens = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String token : tokens) {
            result.append(translateToken(token)).append(" ");
        }

        return result.toString().trim();
    }

    private String translateToken(String token) {
        String prefix = "";
        String suffix = "";
        String word = token;

        while (!word.isEmpty()) {
            prefix += word.charAt(0);
            word = word.substring(1);
        }

        while (!word.isEmpty() ) {
            suffix = word.charAt(word.length() - 1) + suffix;
            word = word.substring(0, word.length() - 1);
        }

        if (word.isEmpty()) {
            return token;
        }

        String translation = dictionary.get(word);

        if (translation == null) {
            return prefix + "*" + word + "*" + suffix;
        }

        return prefix + translation + suffix;
    }
}
