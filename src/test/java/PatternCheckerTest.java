import jsl.groups.strings.PatternChecker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PatternCheckerTest {

    @Test
    public void patternFalse() {
        var resultTrue = PatternChecker.patternChecker("abba", "foo baz baz foo");
        var resultFalse = PatternChecker.patternChecker("abba", "foo baz buz foo");

        assertAll(
                () -> assertThat(resultTrue).isTrue(), /* assertTrue(resultTrue) */
                () -> assertFalse(resultFalse)
        );
    }
}
