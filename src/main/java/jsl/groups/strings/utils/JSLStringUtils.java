package jsl.groups.strings.utils;

import java.util.List;
import java.util.Map;

/**
 * The interface Jsl string utils.
 *
 * @author github.com /Just-StyX
 */
public interface JSLStringUtils {
    /**
     * Reverse letters string.
     *
     * @param word the word
     * @return the reverse of word
     */
    String reverseLetters(String word);

    /**
     * Reverse words string.
     *
     * @param sentence the sentence
     * @return the reverse words in sentence
     */
    String reverseWords(String sentence);

    /**
     * Reverse sentence string.
     *
     * @param sentence the sentence
     * @return the reverse of the whole sentence
     */
    String reverseSentence(String sentence);

    /**
     * Contains only digits boolean.
     *
     * @param string the string
     * @return true if the string contains only integers
     */
    boolean containsOnlyDigits(String string);

    /**
     * Count consonants and vowels map.
     *
     * @param string the string
     * @return the map of vowels count in a word
     */
    Map<String, Long> countConsonantsAndVowels(String string);

    /**
     * Count consonant and vowel each word map.
     *
     * @param sentence the sentence
     * @return the map vowels count in a sentence
     */
    Map<String, Map<String, Long>> countConsonantAndVowelEachWord(String sentence);

    /**
     * Occurrence of character long.
     *
     * @param ch     the ch
     * @param string the string
     * @return the occurrence of the character in the sentence
     */
    long occurrenceOfCharacter(char ch, String string);

    /**
     * Most appeared character char.
     *
     * @param string the string
     * @return the char
     */
    Map<Long, List<Character>> mostAppearedCharacter(String string);

    /**
     * Sort strings by length list.
     *
     * @param strings the strings
     * @return the list
     */
    List<String> sortStringsByLength(List<String> strings);

    /**
     * Number of time substring occur long.
     *
     * @param string    the string
     * @param substring the substring
     * @return the long
     */
    long numberOfTimeSubstringOccur(String string, String substring);

    /**
     * Is a sequence of substring boolean.
     *
     * @param string the string
     * @return the boolean
     */
    boolean isASequenceOfSubstring(String string);

    /**
     * Longest substring string.
     *
     * @param string the string
     * @return the string
     */
    String longestSubstringInSequence(String string);
}
