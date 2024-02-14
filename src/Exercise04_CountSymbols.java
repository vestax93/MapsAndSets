import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise04_CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        TreeMap<Character, Integer> elements = new TreeMap<>(); //inicijalizujemo mapu, definisemo kog je tipa key a kog je tipa value
        for (int i = 0; i < input.length(); i++) { //prolazimo kroz string
            char currentChar = input.charAt(i); //izdvajamo slovo po slovo
            if(!elements.containsKey(currentChar)){ //proveravamo da li key kao trenutno slovo vec postoji u okviru nase mape
                elements.put(currentChar,1); //ako ne postoji, dodajemo ga u mapu i stavljamo value=1 (prvi put se pojavilo to slovo)
            } else { //ako postoji
                int currentCount = elements.get(currentChar); //nadjemo prethodnu vrednost (koliko se puta pojavilo)
                elements.replace(currentChar, currentCount + 1); //*zamenimo* vrednost i stavicemo za jednan vecu vrednost
            }
        }
        for(Map.Entry<Character, Integer> pair : elements.entrySet()){ //prolazimo kroz mapu (obratiti paznju na nacin proslaska)
            System.out.printf("%s: %s time/s%n",pair.getKey(), pair.getValue()); //stampamo par po par u formatu iz zadatka
        }
    }
}
