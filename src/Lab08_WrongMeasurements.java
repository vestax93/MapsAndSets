import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab08_WrongMeasurements {

        public static int rows;
        public static int[][] matrix;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            rows = Integer.parseInt(scanner.nextLine()); //broj redova sa konzole

            matrix = new int[rows][]; //inicijalizujemo matricu

            for (int i = 0; i < rows; i++) { //ucitavamo red po red
                matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            int[] valueCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray(); //ucitavamo koordinate

            int wrongValue = matrix[valueCoordinates[0]][valueCoordinates[1]]; //nalazimo koja je to pogresna vrednost po koordinatama

            List<Integer[]> indexes = new ArrayList<>();

            List<Integer> values = new ArrayList<>();

            for (int i = 0; i < rows; i++) { //prolazimo kroz vrste
                for (int j = 0; j < matrix[i].length; j++) { //pristupamo svakom elementu
                    if(matrix[i][j] == wrongValue){ //ako je element jednak tom pogresnom
                        int value = getCorrectValue(matrix, i, j, wrongValue); //pozivamo f-ju da izracunamo pravu vrednost
                        values.add(value);//dodaje se vrednost koju je potrebno upisati
                        Integer[] pos = new Integer[2]; //pamtimo poziciju gde cemo staviti tu novu vrednost
                        pos[0] = i;
                        pos[1] = j;
                        indexes.add(pos); //dodali indeks u niz na istoj poziciji gde je vrednost u nizu za vrednosti
                    }
                }
            }

            for (int i = 0; i < indexes.size(); i++) {
                matrix[indexes.get(i)[0]][indexes.get(i)[1]] = values.get(i);
            }

            for (int i = 0; i < rows; i++) { //stampanje matrice
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        }

        private static int getCorrectValue(int[][] matrix, int i, int j, int wrongValue) {
            int value = 0;
            if(isInBounds(i - 1, j) && matrix[i - 1][j] != wrongValue){ //element iznad + nije jedna pogresnoj vrednosti
                value += matrix[i - 1][j];
            }
            if(isInBounds(i + 1, j)  && matrix[i + 1][j] != wrongValue){ //element ispod + nije jedna pogresnoj vrednosti
                value += matrix[i + 1][j];
            }
            if(isInBounds(i, j - 1) && matrix[i][j - 1] != wrongValue){ //element levo + nije jedna pogresnoj vrednosti
                value += matrix[i][j- 1];
            }
            if(isInBounds(i, j + 1) && matrix[i][j + 1] != wrongValue){ //element desno + nije jedna pogresnoj vrednosti
                value += matrix[i][j + 1];
            }

            return value;
        }

        private static boolean isInBounds(int i, int j) {
            return i >= 0 && j >= 0 && i < rows && j < matrix[0].length;
        }


}
