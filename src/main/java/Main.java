import java.io.IOException;

/**
 * Runs the English-Spanish dictionary program.
 */
public class Main {

    /**
     * Loads the dictionary, prints the in-order traversal, and translates the input text.
     *
     * @param args optional arguments: dictionary path and text path
     */
    public static void main(String[] args) {
        String dictionaryPath = args.length > 0 ? args[0] : "diccionario.txt";
        String textPath = args.length > 1 ? args[1] : "text.txt";

        TxTManager txtManager = new TxTManager();

        try {
            DictionaryTree dictionary = txtManager.loadDictionary(dictionaryPath);

            System.out.println("Dictionary in-order:");
            for (Translation<String, String> association : dictionary.inOrder()) {
                System.out.print(association + " ");
            }

            String text = txtManager.readText(textPath);
            Translator translator = new Translator(dictionary);

            System.out.println("\n\nTranslation:");
            System.out.println(translator.translate(text));

        } catch (IOException exception) {
            System.out.println("File error: " + exception.getMessage());
        }
    }
}
