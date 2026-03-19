package velkyUkol1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainVU1 {
    void main() {
        Random rand = new Random();
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

                    Pattern pattern1 = Pattern.compile("\\d{1,2}\\.\\s?\\d{1,2}\\.\\s?\\d{4}");
                    Matcher matcher2 = pattern1.matcher(datum);

                    if(matcher2.matches()){
                        int prvniTecka = line.indexOf(".");
                        int druhaTecka = line.indexOf(".", prvniTecka+1);

                        String day =  line.substring(prvniTecka+1, druhaTecka);
                        String month =  line.substring(druhaCarka+1, prvniTecka);
                        String year =  line.substring(druhaTecka+1, tretiCarka);
                        datumSpravne = (day+ ". " +month+ ". " +year);


                    }else{
                        int prvniLomeno = line.indexOf("/");
                        int druheLomeno = line.indexOf("/", prvniLomeno+1);

                        String month =  line.substring(prvniLomeno+1, druheLomeno);
                        String year =  line.substring(druhaCarka+1, prvniLomeno);
                        String day =  line.substring(druheLomeno+1, tretiCarka);
                        datumSpravne = (day+ ". " +month+ ". " +year);
                    }

                //-----------------------------------------------------------------------
                    String telefonSpravne = "";
                    //tretiCarka - ctvrtaCarka
                    String telefon = line.substring(tretiCarka+1, ctvrtaCarka);

                    Pattern patternTelefon = Pattern.compile("\\d{3}\\s\\d{3}\\s\\d{3}");
                    Matcher matcherTelefon = patternTelefon.matcher(telefon);

                   if(matcherTelefon.matches()){
                       telefonSpravne = telefon;
                   }else{
                       int prvniMinus = line.indexOf("-");
                       int druheMinus = line.indexOf("-", prvniMinus+1);

                       String prvniCastTelefonu =  line.substring(tretiCarka+1, prvniMinus);
                       String druhaCastTelefonu =  line.substring(prvniMinus+1, druheMinus);
                       String tretiCastTelefonu =  line.substring(druheMinus+1, ctvrtaCarka);

                       telefonSpravne = (prvniCastTelefonu+ " " +druhaCastTelefonu+ " 0" +tretiCastTelefonu);
                   }

                //-----------------------------------------------------------------------
                   String emailSpravne = "";
                   String email = line.substring(ctvrtaCarka);

                    int zavinac = line.indexOf("@");

                    String prvniCastEmailu =  line.substring(ctvrtaCarka+1, zavinac);
                    String druhaCastEmailu =  line.substring(zavinac+1);

                    if (!email.equals("spatny.email.cz")){

                        for(int i = 0; i < email.length(); i++){
                            switch (email.charAt(i)) {
                                case 'ě': emailSpravne += 'e';
                                    break;

                                case 'š': emailSpravne += 's';
                                    break;

                                case 'č': emailSpravne += 'c';
                                    break;

                                case 'ř': emailSpravne += 'r';
                                    break;

                                case 'ž': emailSpravne += 'z';
                                    break;

                                case 'ý': emailSpravne += 'y';
                                    break;

                                case 'á': emailSpravne += 'a';
                                    break;

                                case 'í': emailSpravne += 'i';
                                    break;

                                case 'é': emailSpravne += 'e';
                                    break;

                                default: emailSpravne += email.charAt(i);
                                    break;
                            }
                        }

                    }else{
                        String jmeno = line.substring(0 , prvniCarka);
                        String prijmeni = line.substring(prvniCarka+1, druhaCarka);
                        int randomCislo = rand.nextInt(1000);

                        email = (jmeno+ "." +prijmeni+randomCislo+ "@seznam.cz");
                        for(int i = 0; i < email.length(); i++){
                            switch (email.charAt(i)) {
                                case 'ě': emailSpravne += 'e';
                                    break;

                                case 'š': emailSpravne += 's';
                                    break;

                                case 'č': emailSpravne += 'c';
                                    break;

                                case 'ř': emailSpravne += 'r';
                                    break;

                                case 'ž': emailSpravne += 'z';
                                    break;

                                case 'ý': emailSpravne += 'y';
                                    break;

                                case 'á': emailSpravne += 'a';
                                    break;

                                case 'í': emailSpravne += 'i';
                                    break;

                                case 'é': emailSpravne += 'e';
                                    break;

                                default: emailSpravne += email.charAt(i);
                                    break;
                            }
                        }

                    }
















                }











            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }

}
