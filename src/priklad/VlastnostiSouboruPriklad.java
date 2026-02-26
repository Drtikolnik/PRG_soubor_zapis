package priklad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;

public class VlastnostiSouboruPriklad {

    public static void main(String[] args) {

        // Relativní cesta ke složce
        Path slozka = Path.of("data");

        try {

            // Vytvoření složky (pokud neexistuje)
            if (!Files.exists(slozka)) {
                Files.createDirectory(slozka);
                System.out.println("Složka vytvořena.");
            }

            // Cesta k souboru uvnitř složky
            Path soubor = slozka.resolve("test.txt");

            // Vytvoření souboru (pokud neexistuje)
            if (!Files.exists(soubor)) {
                Files.createFile(soubor);
                System.out.println("Soubor vytvořen.");
            }

            // Základní informace o souboru
            System.out.println("\n--- Informace o souboru ---");
            System.out.println("Název: " + soubor.getFileName());
            System.out.println("Relativní cesta: " + soubor);
            System.out.println("Absolutní cesta: " + soubor.toAbsolutePath());
            System.out.println("Existuje: " + Files.exists(soubor));
            System.out.println("Je soubor: " + Files.isRegularFile(soubor));
            System.out.println("Je složka: " + Files.isDirectory(soubor));
            System.out.println("Je čitelný: " + Files.isReadable(soubor));
            System.out.println("Je zapisovatelný: " + Files.isWritable(soubor));

            // Pokročilé vlastnosti souboru
            BasicFileAttributes attrs =
                    Files.readAttributes(soubor, BasicFileAttributes.class);

            System.out.println("\n--- Detailní vlastnosti ---");
            System.out.println("Velikost (B): " + attrs.size());
            System.out.println("Vytvořen: " +
                    Instant.ofEpochMilli(attrs.creationTime().toMillis()));
            System.out.println("Poslední změna: " +
                    Instant.ofEpochMilli(attrs.lastModifiedTime().toMillis()));
            System.out.println("Je adresář: " + attrs.isDirectory());
            System.out.println("Je běžný soubor: " + attrs.isRegularFile());

            // Výpis obsahu složky
            System.out.println("\n--- Obsah složky data ---");
            Files.list(slozka)
                    .forEach(p -> System.out.println(p.getFileName()));

        } catch (IOException e) {
            System.out.println("Chyba při práci se souborovým systémem:");
            e.printStackTrace();
        }
    }
}