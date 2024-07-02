import jsl.groups.strings.JSLStringUtilsImplementation;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class JSLStringUtilsImplementationTests {
    JSLStringUtilsImplementation stringUtilsImplementation = new JSLStringUtilsImplementation();

    @Test
    public void setStringUtilsImplementation() {
        assertAll(
                () -> assertThat("ippississim").isEqualTo(stringUtilsImplementation.reverseLetters("mississippi")),
                () -> assertThat("ippississim ot nas ogeid").isEqualTo(stringUtilsImplementation.reverseWords("mississippi to san diego")),
                () -> assertThat("diego san to mississippi").isEqualTo(stringUtilsImplementation.reverseSentence("mississippi to san diego")),
                () -> assertFalse(stringUtilsImplementation.containsOnlyDigits("")),
                () -> assertThat(0).isEqualTo(stringUtilsImplementation.occurrenceOfCharacter(')', "")),
                () -> assertThat(3).isEqualTo(stringUtilsImplementation.occurrenceOfCharacter('m', "my mum")),
                () -> assertThat(Map.of(4L, List.of('s', 'i'))).isEqualTo(stringUtilsImplementation.mostAppearedCharacter("mississippi")),
                () -> assertThat(List.of("new york", "mississippi", "california san frans"))
                        .isEqualTo(stringUtilsImplementation.sortStringsByLength(List.of("mississippi", "new york", "california san frans"))),
                () -> assertThat(1).isEqualTo(stringUtilsImplementation.numberOfTimeSubstringOccur("111", "11")),
                () -> assertThat(2).isEqualTo(stringUtilsImplementation.alternateSolutionNumberOfTimeSubstringOccur("111", "11")),
                () -> assertTrue(stringUtilsImplementation.isASequenceOfSubstring("x")),
                () -> assertFalse(stringUtilsImplementation.isASequenceOfSubstring("ab")),
                () -> assertTrue(stringUtilsImplementation.isASequenceOfSubstring("xyz-xyz-")),
                () -> assertFalse(stringUtilsImplementation.isASequenceOfSubstring("xyz-xyz-xyz"))
        );
    }
}
