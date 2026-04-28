import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Reads the dictionary file and the text file.
 */
public class TxTManager {

    /**
     * Loads dictionary associations from a file with format: (english, spanish).
     *
     * @param path the dictionary file path
     * @return the loaded dictionary
     * @throws IOException if the file cannot be read
     */
    public DictionaryTree loadDictionary(String path) throws IOException {
        DictionaryTree dictionary = new DictionaryTree();
        List<String> lines = Files.readAllLines(Path.of(path));

        for (String line : lines) {
            String cleanLine = line.trim();

            if (cleanLine.isEmpty()) {
                continue;
            }

            if (cleanLine.startsWith("(") && cleanLine.endsWith(")")) {
                cleanLine = cleanLine.substring(1, cleanLine.length() - 1);
            }

            String[] parts = cleanLine.split(",", 2);

            if (parts.length == 2) {
                dictionary.put(parts[0], parts[1]);
            }
        }

        return dictionary;
    }

    /**
     * Reads a complete text file.
     *
     * @param path the text file path
     * @return the text content
     * @throws IOException if the file cannot be read
     */
    public String readText(String path) throws IOException {
        return Files.readString(Path.of(path));
    }
}
