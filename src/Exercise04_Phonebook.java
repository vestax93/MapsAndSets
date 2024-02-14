import java.util.HashMap;
import java.util.Scanner;

public class Exercise04_Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        HashMap<String, String> phonebook = new HashMap<>(); //formiramo imenik, key je ime, a value je broj telefona
        while(!command.equals("search") && !command.equals("stop")){ //dok nemamo naredbu search ili stop, ucitavamo imena
            String[] nameAndNumber = command.split("-"); //ucitanu komandu splitujemo po - i dobijamo ime i broj telefona
            String name = nameAndNumber[0]; //prvi clan je ime
            String phoneNumber = nameAndNumber[1]; //drugi clan je broj telefona
            phonebook.put(name,phoneNumber); //to stavljamo u mapu
            command = sc.nextLine(); //ucitavamo sledecu komandu (napomena da se ne zanesete kod splita jer onda ucitavamo duplo :()
        }
        if(command.equals("search") || !command.equals("stop")){ //ucitavamo ime koje je potrebno pronaci
            command = sc.nextLine();
        }
        while(!command.equals("stop")){ //dok nije korisnik ukucao stop
            if(phonebook.containsKey(command)){ //proveravamo da li to ime (key) postoji u imeniku
                System.out.printf("%s -> %s%n",command, phonebook.get(command)); //ako postoji, ispusjemo ime -> broj telefona
            } else {
                System.out.printf("Contact %s does not exist.%n",command); //ispisujemo da ne postoji (u formatu sa primera)
            }
            command = sc.nextLine();//ucitavamo sledecu komandu
        }

    }
}
