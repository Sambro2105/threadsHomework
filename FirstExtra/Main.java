package FirstExtra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Get user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные: ");
        String line = sc.nextLine();

        // Transforming user input to array of strings
        ArrayList<String> data = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"(.*?)\"", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            data.add(matcher.group(1));
        }

        String answer = getWinner(data);
        System.out.println(answer);
    }

    /**
    Return the earliest winner of the game
    */
    static public String getWinner(ArrayList<String> data) {
        Map<String, Integer> results = new HashMap<>();
        data.forEach(result -> {
            String[] a = result.split(" ");
            String name = a[0];
            Integer score = Integer.valueOf(a[1]);
            results.putIfAbsent(name, 0);
            results.put(name, results.get(name) + score);
        });

        return results.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }
}
