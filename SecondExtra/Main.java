package SecondExtra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Get user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные: ");
        String line = sc.nextLine().trim();

        // Transforming user input to array of Integers
        ArrayList<Integer> data = new ArrayList<>();
        String[] strings = line.split(" ");
        for (String string : strings) {
            data.add(Integer.valueOf(string));
        }

        int answer = getCoolInteger(new HashSet<>(data));
        System.out.println(answer);
    }

    /**
     * Возвращает наименьшее неотрицательное число
     * которое можно: прибавить, вычесть или оставить без изменения элемент входной последовательности,
     * чтобы все элементы последовательности стали равными
     */
    static public int getCoolInteger(Set<Integer> data) {
        // By default the answer is -1
        int result = -1;

        // Let's find min, max and delta between them
        int[] sorted = data.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int min = sorted[0];
        int max = sorted[sorted.length - 1];
        int delta = max - min;

        // If the difference between min and max is 0 or 1, then is answer is that difference
        if (delta == 0 || delta == 1)
            result = delta;

        // Otherwise the answer could be half the difference, but we have to check every number
        // in the array if it fits every criteria
        else {
            if (delta % 2 == 0) {
                int possibleResult = delta / 2;
                int requiredInt = min + possibleResult;
                for (int item : data) {
                    if ((item < requiredInt && item + possibleResult != requiredInt) ||
                            (item > requiredInt && item - possibleResult != requiredInt)) {
                        possibleResult = -1;
                        break;
                    }
                }
                result = possibleResult;
            }
        }
        return result;
    }
}
