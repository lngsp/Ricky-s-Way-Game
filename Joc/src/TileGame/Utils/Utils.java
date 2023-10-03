package TileGame.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Utilități
public class Utils {

    // loadFileAsString încarcă un fișier
    // returneaza un String cu, conținutul fișierului
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();    //adaugă un caracter la String

        try {
            BufferedReader br = new BufferedReader(new FileReader((path)));
            String line;
            while((line = br.readLine()) != null)   //cât timp următoarea linie de citit nu este null
                builder.append(line + "\n");    // adaugă la String linia nouă
            br.close(); //close the file
        }catch(IOException e){
            e.printStackTrace();    // afișează eroare pe ecran
        }
        return builder.toString();
    }

    public static int parseInt(String number){
        // "5" -> 5

        try{
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            // Dacă adăugăm un String care nu este număr (cum ar fi „a”)
            e.printStackTrace();
            return 0;
        }
    }
}
