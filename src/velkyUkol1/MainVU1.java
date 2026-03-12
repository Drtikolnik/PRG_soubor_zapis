package velkyUkol1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainVU1 {
    void main() {
        //mm.dd.yyyy  -->   dd.mm.yyyy   --> 2-3
        //xxx-xxx-xxx -->   xxx xxx xxx  --> 3-4
        //ěščřžýáíé   -->   escrzyaie    --> 4-

        Path soubor = Path.of("data", "studenti_1000.csv");

        try {
            List<String> lines = Files.readAllLines(soubor);
            for (String line : lines) {

                if(line.contains("Jmeno")){

                }else{
                    int prvniCarka = line.indexOf(",");
                    int druhaCarka = line.indexOf(",", prvniCarka+1);
                    int tretiCarka = line.indexOf(",", druhaCarka+1);
                    int ctvrtaCarka = line.indexOf(",", tretiCarka+1);

                //-----------------------------------------------------------------------
                    String datumSpravne = "";
                    String datum = line.substring(druhaCarka+1, tretiCarka);

                    Pattern pattern = Pattern.compile("\\d{1,2}\\.\\s?\\d{1,2}\\.\\s?\\d{4}");
                    Matcher matcher = pattern.matcher(datum);

                    if(matcher.matches()){
                        int prvniTecka = line.indexOf(".");
                        int druhaTecka = line.indexOf(".", prvniTecka+1);

                        String day =  line.substring(prvniTecka+2, druhaTecka);
                        String month =  line.substring(druhaCarka+1, prvniTecka);
                        String year =  line.substring(druhaTecka+2, tretiCarka);
                        datumSpravne = (day+ ". " +month+ ". " +year);

                    }else{

                    }

                //-----------------------------------------------------------------------
                    String telefonSpravne = "";

                    //int prvniTecka = line.indexOf(".");
                    //int druhaTecka = line.indexOf(".", prvniTecka+1);









                }






















            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }

}
