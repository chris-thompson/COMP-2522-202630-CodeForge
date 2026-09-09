package ca.bcit.comp2522.maps.wordPlay;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * WordTypeCount demonstrates how to use a Map and Scanner in an innovative way.
 *
 * @author BCIT
 * @version 2026
 */
public final class WordTypeCount {

    private final HashMap<String, Integer> map;

    /**
     * Constructs an object of type WordTypeCount.
     */
    public WordTypeCount() {
        map = new HashMap<>();
        createMap();
        displayMap();
    }

    /*
     * Populates the map with some tokens entered by the user.
     */
    private void createMap() {
        System.out.println("Enter a string:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
    }

    /*
     * Displays the map.StringTokenizer
     */
    private void displayMap() {
        Set<String> keys = map.keySet();
        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.println("Map contains:\nKey\t\t\tValue");
        for (String key : sortedKeys) {
            System.out.printf("%-10s%10s%n", key, map.get(key));
        }

        System.out.printf("%nsize:%d%nisEmpty:%b%n", map.size(), map.isEmpty());
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        new WordTypeCount();
    }
}
