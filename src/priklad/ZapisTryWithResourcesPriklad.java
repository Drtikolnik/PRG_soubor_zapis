package priklad;

import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ZapisTryWithResourcesPriklad {

    public static void main(String[] args) {

        // Relativní cesta k souboru
        Path soubor = Path.of("data", "studenti_1000.csv");

        try {
            List<String> lines = Files.readAllLines(soubor);
            for (String line : lines) {
                System.out.println(line);
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {

            // Vytvoření složky, pokud neexistuje
            if (!Files.exists(soubor.getParent())) {
                Files.createDirectories(soubor.getParent());
            }

            // Otevření BufferedWriter v try-with-resources
            try (BufferedWriter writer = Files.newBufferedWriter(
                    soubor,
                    StandardOpenOption.CREATE,       // vytvoří soubor, pokud neexistuje
                    StandardOpenOption.TRUNCATE_EXISTING // přepíše obsah
            )) {

                writer.write("První řádek textu");
                writer.newLine();

                writer.write("Druhý řádek textu");
                writer.newLine();

                writer.write("Třetí řádek textu");
                writer.newLine();
            }

            System.out.println("Zápis proběhl úspěšně.");
            System.out.println("Absolutní cesta: " + soubor.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Chyba při zápisu do souboru:");
            e.printStackTrace();
        }
    }
}