import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise06_FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, String> emails = new LinkedHashMap<>(); //inicijalizujemo mapu za imena i mejlove
        String name = sc.nextLine();
        String email = "";
        while(!name.equals("stop")){ //petlja vrti dok se ne napise stop
            email = sc.nextLine(); //ucitavamo mejl za dato ime
            if(!email.endsWith(".uk") && !email.endsWith(".us") && !email.endsWith(".com")){ //provera da li ispunjava uslove tj. NE sadrzi .us, .uk i .com
                emails.put(name,email);
            }
            name = sc.nextLine(); //ucitavamo sledece ime
        }
        for(Map.Entry<String, String> pair : emails.entrySet()){ //stampamo sve parove iz mape
            System.out.printf("%s -> %s%n",pair.getKey(),pair.getValue()); //formatiramo kao u primeru
        }
    }
}
