import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Runs the English-Spanish dictionary program with a simple menu.
 */
public class Main {

    public static void main(String[] args) {

        String dictionaryPath = "diccionario.txt";
        String textPath = "text.txt";
        String traduction = "resultado.txt";
        String inorder = "In-Order.txt";

        TxTManager txtManager = new TxTManager();
        Scanner scanner = new Scanner(System.in);

        try {
            DictionaryTree dictionary = txtManager.loadDictionary(dictionaryPath);
            String text = txtManager.readText(textPath);
            Translator translator = new Translator(dictionary);

            int option = 0;

            while (option != 3) {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Traducir texto (en text.txt)");
                System.out.println("2. Mostrar In-Order");
                System.out.println("3. Salir");

                option = scanner.nextInt();

                if (option == 1) {
                    String result = translator.translate(text);

                    System.out.println("\n Traduccion:");

                    Files.writeString(Path.of(traduction), result);
                    System.out.println("Traduccion en resultado.txt");

                } else if (option == 2) {

                    System.out.println("\nDictionary in-order:");
                    for (Translation<String, String> association : dictionary.inOrder()) {
                        Files.writeString(Path.of(inorder), association.toString());

                    }

                } else if (option == 3) {

                    System.out.println("Saliendo");

                } else {

                    System.out.println("Opción invalida");

                }
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        scanner.close();
    }
}