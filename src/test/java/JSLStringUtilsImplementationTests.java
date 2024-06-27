import jsl.groups.strings.JSLStringUtilsImplementation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
                () -> assertThat(3).isEqualTo(stringUtilsImplementation.occurrenceOfCharacter('m', "my mum"))
        );
    }
}