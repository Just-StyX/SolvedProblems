package jsl.groups.strings;

import jsl.groups.strings.utils.JSLStringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Jsl string utils implementation.
 *
 * @author github.com/Just-StyX
 */
public class JSLStringUtilsImplementation implements JSLStringUtils {
    @Override
    public String reverseLetters(String word) {
        return reverseLetters(word, "", word.length() - 1);
    }

    @Override
    public String reverseWords(String sentence) {
        return Arrays.stream(sentence.split(" ")).map(
                this::reverseLetters
        ).collect(Collectors.joining(" "));
    }

    @Override
    public String reverseSentence(String sentence) {
        return String.join(" ", Arrays.stream(sentence.split(" ")).toList().reversed());
    }

    @Override
    public boolean containsOnlyDigits(String string) {
        var array = string.split("");
        if (array.length == 0 || string.isBlank()) {
            return false;
        } else {
            for (String str: array) {
                if (!Character.isDigit(str.charAt(0)) && !str.isBlank()) return false;
            }
        }
        return true;
    }

    @Override
    public Map<String, Long> countConsonantsAndVowels(String string) {
        if (string.isBlank()) {
            return null;
        }
        var vowelString = "aeiou";
        long vowels = 0, consonants = 0;
        for (String str: string.split("")) {
            if (vowelString.contains(str)) vowels++;
            else consonants++;
        }
        return Map.of("vowels", vowels, "consonants", consonants);
    }

    @Override
    public Map<String, Map<String, Long>> countConsonantAndVowelEachWord(String sentence) {
        Map<String, Map<String, Long>> stringMapMap = new HashMap<>();
        Arrays.stream(sentence.split(" ")).forEach(word -> stringMapMap.put(word, countConsonantsAndVowels(word)));
        return stringMapMap;
    }

    @Override
    public long occurrenceOfCharacter(char ch, String string) {
        var result = string.codePoints()
                .mapToObj(
                        c -> String.valueOf(Character.valueOf((char) c))
                ).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        return result.getOrDefault(String.valueOf(ch), 0L);
    }

    /**
     * Reverse letters string.
     *
     * @param word   the word
     * @param result the result
     * @param index  the index
     * @return the reverse of word
     */
    public String reverseLetters(String word, String result, int index) {
        if (index < 0) return result;
        else return reverseLetters(word, result + word.charAt(index), index - 1);
    }

    public String removeWhiteSpaces(String string) {
        return string.replaceAll("\\s", "");
    }
}