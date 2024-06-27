package jsl.groups.strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Count duplicate characters.
 *
 * @author github.com /Just-StyX
 */
public class CountDuplicateCharacters {
    /**
     * Count duplicates map.
     *
     * @param word the word
     * @return the map
     */
    public Map<String, Long> countDuplicates(String word) {
        return word.codePoints()
                .mapToObj(
                        c -> String.valueOf(Character.valueOf((char) c))
                ).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
    }

    /**
     * Remove duplicates string.
     *
     * @param word the word
     * @return the string
     */
    public String removeDuplicates(String word) {
        return String.join("", countDuplicates(word).keySet());
    }

    /**
     * Remove duplicates of characters in a sentence string.
     *
     * @param sentence the sentence
     * @return the string
     */
    public String removeDuplicatesOfCharactersInASentence(String sentence) {
        return Arrays.stream(sentence.split(" ")).map(
                this::removeDuplicates
        ).collect(Collectors.joining(" "));
    }

    /**
     * First non repeated character char.
     *
     * @param word the word
     * @return the char
     */
    public char firstNonRepeatedCharacter(String word) {
        char result = word.charAt(0);
        var countMap = countDuplicates(word);
        for (String str: countMap.keySet()) {
            if (countMap.get(str) == 1) {
                result = str.charAt(0);
                break;
            }
        }
        return result;
    }
}
