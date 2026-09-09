package ca.bcit.comp2522.maps.wordPlay;

import java.util.HashMap;
import java.util.Map;

/**
 * MapTester.
 *
 * @author BCIT
 * @version 2026
 */
public final class MapTester {

    private final HashMap<Character, Integer> letterCount;

    /**
     * Constructor for objects of type MapTester.
     */
    public MapTester() {
        letterCount = new HashMap<>();
    }

    /**
     * Counts and reports the number of each letter in a specified sentence.
     *
     * @param sentence A string
     */
    public void countLetters(final String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            if (letterCount.containsKey(sentence.charAt(i))) {
                letterCount.put(sentence.charAt(i), letterCount.get(sentence.charAt(i)) + 1);
            } else {
                letterCount.put(sentence.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
