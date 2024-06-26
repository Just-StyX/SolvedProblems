package jsl.groups.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Pattern checker.
 * @author github.com/Just-StyX
 */
public class PatternChecker {

    /**
     * Pattern checker boolean.
     * @author github.com/Just-StyX
     *
     * @param pattern the pattern
     * @param input   the input
     * @return the boolean
     */
    public static boolean patternChecker(String pattern, String input) {
        final int lengthOfPattern = pattern.length();
        final String[] strings = input.split(" ");
        final int lengthOfStrings = strings.length;

        if (lengthOfStrings != lengthOfPattern || (strings.length == 1 && strings[0].isEmpty())) {
            return false;
        }

        final Map<Character, String> characterStringHashMap = new HashMap<>();

        for (int i  = 0; i < lengthOfPattern; i++) {
            char character = pattern.charAt(i);
            String string = strings[i];

            characterStringHashMap.putIfAbsent(character, string);

            String assignedValue = characterStringHashMap.get(character);
            if (!assignedValue.equals(string)) {
                return false;
            }
        }
        return true;
    }
}
