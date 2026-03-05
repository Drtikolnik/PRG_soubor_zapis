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

public class Ukol2 {
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
                    "0",
                    "-168",
                    "587",
                    "25",
                    "4",
                    "84"

            );



            // Zápis do souboru (vytvoří nebo přepíše soubor)
            Files.write(soubor, radky);
            List<String> radkyCisla = Files.readAllLines(soubor);


            int velikost = 1;
            int celkem = 0;

            for (String s : radky) {
                celkem += Integer.parseInt(s);
                if (velikost == 1) {
                    System.out.print(s);
                    velikost++;
                }else if (velikost < radky.size()) {
                    if( Integer.parseInt(s) < 0){
                        System.out.print(" + (" +s+ ")");
                    }else{
                        System.out.print(" + " +s);
                    }
                    velikost++;
                }else{
                    if( Integer.parseInt(s) <= 0){
                        System.out.print(" + (" +s+ ") = " +celkem);
                    }else{
                        System.out.print(" + " +s+ " = " +celkem);
                    }
                    velikost++;
                }

            }



            System.out.println("");
            System.out.println("Zápis proběhl úspěšně.");
            System.out.println("Absolutní cesta: " + soubor.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Chyba při zápisu do souboru:");
            e.printStackTrace();
        }



    }
}



