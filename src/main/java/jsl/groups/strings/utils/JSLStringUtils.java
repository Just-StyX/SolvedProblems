package jsl.groups.strings.utils;

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
}
