import java.util.LinkedHashSet;
import java.util.Scanner;

public class Exercise02_SetOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" "); //ucitavamo dimenzije prvog i drugog skupa odvojene razmakom
        int n = Integer.parseInt(numbers[0]); //dimenzije prvog skupa (set-a)
        int m = Integer.parseInt(numbers[1]); //dimenzije drugog skupa (set-a)

        LinkedHashSet<String> set1 = new LinkedHashSet<>(); //inicijalizacija prvog skupa
        LinkedHashSet<String> set2 = new LinkedHashSet<>(); //inicijalizacija drugog skupa

        for (int i = 0; i < n; i++) {
            set1.add(sc.nextLine()); //ucitavanje elemenata prvog skupa (brojac ide do n)
        }

        for (int i = 0; i < m; i++) {
            set2.add(sc.nextLine()); //ucitavanje elemenata drugog skupa (brojac ide do m)
        }

        set1.retainAll(set2); //intersection - presek, koristimo metodu retainAll da bismo zadrzali samo one elemenete koji se nalaze u oba skupa
        //s1.removeAll(s2) - razlika, ostavlja samo one elementa koji se nalaze u s1, ali ne i u s2
        //s1.addAll(s2) - unija, svi elementi koji se nalaze u bilo s1 bilo s2

        String joined = String.join(" ", set1); //spajamo sve elemente kolekcije (drugi parametar) u jedan string i razdvajamo ih razmakom (prvi parametar)
        System.out.println(joined);
    }
}
