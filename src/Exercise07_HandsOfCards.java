import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise07_HandsOfCards {
    public static void main(String[] args) {
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        while(!command.equals("JOKER")){ //dok komanda nije JOKER
            String[] tokens = command.split(":"); //uzimamo ime igraca i karte koje je on izvukao
            String name = tokens[0].trim(); //prvi clan je ime
            if(!players.containsKey(name)){
                players.put(name, new HashSet<>()); //ako je prvi put igrao, inicijalizujemo njegov skupa karata
            }
            String[] cards = tokens[1].trim().split(","); //dobijamo niz karata

            for (int i = 0; i < cards.length; i++) {
                String currentCard = cards[i].trim();
                players.get(name).add(currentCard); //dodajemo kartu po kartu u set, bez duplikata
            }
            command = sc.nextLine();
        }

        for(Map.Entry<String, HashSet<String>> pair : players.entrySet()){
            String currentPlayerName = pair.getKey();
            int points = calculatePoints(pair.getValue()); //racunamo poene
            System.out.printf("%s: %s%n", currentPlayerName, points); //ispisujemo poene
        }
    }

    private static int calculatePoints(HashSet<String> cards) {
        int sum = 0;
        for(String card : cards){
            String power = card.substring(0,card.length()-1); //uzimamo broj karte (obratiti paznju na dvocifrene tj. 10)
            char multiplier = card.charAt(card.length()-1); //uzimamo znak karte

            int powerNumber = calculatePower(power);
            int multiplierNumber = calculateMultiplier(multiplier);
            sum += powerNumber*multiplierNumber; //mnozimo vrednost za broj i vrednost za znak
        }
        return sum;
    }

    private static int calculateMultiplier(char multiplier) {
        switch (multiplier){
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 0;
        }
    }

    private static int calculatePower(String power) {
        switch (power){
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return 0;

        }
    }
}
