package ukoly;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarEntry;

public class Ukol1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Jaký bude název souboru?");
        String nazev = sc.nextLine();

        // Relativní cesta k souboru
        Path soubor = Path.of("data", nazev + ".txt");

        try {

            // Pokud složka neexistuje, vytvoříme ji
            if (!Files.exists(soubor.getParent())) {
                Files.createDirectories(soubor.getParent());
            }

            //ArrayList<String> lines = new ArrayList<>();
            ////while(){}
            //lines.add(nazev);


            // Data k zápisu (více řádků)
            List<String> radky = List.of(
                    "slovo",
                    "ena",
                    "nea",
                    "alnel",
                    "aloaen",
                    "alo"

            );



            // Zápis do souboru (vytvoří nebo přepíše soubor)
            Files.write(soubor, radky);

            System.out.println(Files.readString(soubor));



            System.out.println("Zápis proběhl úspěšně.");
            System.out.println("Absolutní cesta: " + soubor.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Chyba při zápisu do souboru:");
            e.printStackTrace();
        }



    }
}



