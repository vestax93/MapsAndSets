import java.util.LinkedHashSet;
import java.util.Scanner;

public class Exercise01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); //unos broj elemenata koje cemo upisati kasnije (username-ova)

        LinkedHashSet<String> usernames = new LinkedHashSet<>(); //inicijalizacija Set-a
        //LinkedHashSet pamti redosled ubacivanje elemenata u set
        String line; //upisacemo ovde username po username
        for (int i = 0; i < n; i++) { //prolazimo onoliko puta koliko je zadato brojem n na pocetku
            line = sc.nextLine(); //ucitavamo username
            usernames.add(line); //ubacujemo ga u set, ako ne postoji vec u setu bice dodat, a ako postoji nece biti dodat duplikat
        }
        for(String name : usernames){ //prolazimo kroz set
            System.out.println(name); //stampamo imena (obratiti paznju na redosled stampanja jer je u pitanju LinkedHashSet)
        }

    }
}
