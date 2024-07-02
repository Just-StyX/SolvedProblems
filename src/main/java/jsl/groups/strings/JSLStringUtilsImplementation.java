package jsl.groups.strings;

import jsl.groups.strings.utils.JSLStringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    @Override
    public Map<Long, List<Character>> mostAppearedCharacter(String string) {
        List<Character> characterList = new ArrayList<>();
        var key = string.codePoints()
                .mapToObj(c -> String.valueOf(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue(Comparator.naturalOrder()));

        long getKeyValue = 0;

        if (key.isPresent()) {
            var sorted = string.codePoints()
                    .mapToObj(c -> String.valueOf(Character.valueOf((char) c)))
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

            getKeyValue = key.get().getValue();
            for (String str: sorted.keySet()) {
                if (Objects.equals(getKeyValue, sorted.get(str))) characterList.add(str.charAt(0));
            }
        }
        return Map.of(getKeyValue, characterList);
    }

    @Override
    public List<String> sortStringsByLength(List<String> strings) {
        Function<String, Integer> function = String::length;
        return strings.stream().sorted(Comparator.comparing(function)).toList();
    }

    @Override
    public long numberOfTimeSubstringOccur(String string, String substring) {
        return numberOfTimeSubstringOccur(string, substring, 0);
    }

    @Override
    public boolean isASequenceOfSubstring(String string) {
        return isASequenceOfSubstring(string, "", 0);
    }

    @Override
    public String longestSubstringInSequence(String string) {
        return string.substring(0, longestSubstringInSequence(string, "", 0));
    }

    /**
     * Alternate solution number of time substring occur long.
     * This is a fascinating solution. Check it out.
     *
     * @param string    the string
     * @param substring the substring
     * @return the long
     */
    public long alternateSolutionNumberOfTimeSubstringOccur(String string, String substring) {
        Pattern pattern = Pattern.compile(Pattern.quote(substring));
        Matcher matcher = pattern.matcher(string);

        int pos = 0; long count = 0;

        while (matcher.find(pos)) {
            pos = matcher.start() + 1;
            count++;
        }
        return count;
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

    /**
     * Number of time substring occur long. A helper function
     *
     * @param string    the string
     * @param substring the substring
     * @param result    the result
     * @return the number of occurrence of the substring
     */
    public long numberOfTimeSubstringOccur(String string, String substring, long result) {
        if (!string.contains(substring)) return result;
        else {
            result++;
            return numberOfTimeSubstringOccur(string.replaceFirst(substring, ""), substring, result);
        }
    }

    /**
     * Is a sequence of substring boolean. A helper function
     *
     * @param string    the string
     * @param substring the substring
     * @param count     the count
     * @return the boolean
     */
    public boolean isASequenceOfSubstring(String string, String substring, int count) {
        if (string.replaceAll(substring, "").isEmpty() || string.length() == 1 ) return true;
        else {
            if (count >= string.length() / 2) return false;
            else {
                substring += string.charAt(count);
                count++;
                return isASequenceOfSubstring(string, substring, count);
            }
        }
    }

    public int longestSubstringInSequence(String string, String substring, int count) {
        if (string.length() == 1) return 1;
        if (string.replaceAll(substring, "").isEmpty() ) return count;
        else {
            if (count >= string.length() / 2) return 0;
            else {
                substring += string.charAt(count);
                count++;
                return longestSubstringInSequence(string, substring, count);
            }
        }
    }
}
