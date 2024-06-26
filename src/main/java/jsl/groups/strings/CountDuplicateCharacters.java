package jsl.groups.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Count duplicate characters.
 * @author github.com/Just-StyX
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
}
