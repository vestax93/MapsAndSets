import java.util.Scanner;
import java.util.TreeSet;

public class Exercise03_PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); //broj linije koje ce biti unete (ne elemenata jer jedna linija moze imati vise elemenata)
        TreeSet<String> elements = new TreeSet<>(); //inicijalizacija TreeSet-a (ne sadrzi duplikate i sortira po redosledu (abecednom))

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" "); //svaki red, splitujemo po razmaku da bismo dobili niz elemenata u toj "smesi"
            for (int j = 0; j < tokens.length; j++) { //prolazimo kroz niz elemenata u smesi
                elements.add(tokens[j]); //dodajemo u TreeSet (ne brinemo o duplikatima, jer je to po defaultu)
            }
        }
        String joined = String.join(" ", elements); //pravimo jedan string sa svim elementima
        System.out.println(joined);
    }
}
