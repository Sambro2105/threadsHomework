package FirstExtra;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
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
     * Return the earliest winner of the game
     */
    static public String getWinner(ArrayList<String> data) {
        Map<String, Integer> results = new HashMap<>();
        String[] currentWinner = new String[1];
        final AtomicInteger currentWinnerScore = new AtomicInteger(0);

        data.forEach(result -> {
            String[] nameScore = result.split(" ");
            String name = nameScore[0];
            int score = Integer.parseInt(nameScore[1]);

            results.putIfAbsent(name, 0);
            int newScore = results.get(name) + score;
            results.put(name, newScore);

            if (newScore > currentWinnerScore.get()) {
                currentWinner[0] = name;
                currentWinnerScore.set(newScore);
            }
        });

        return currentWinner[0];
    }
}
