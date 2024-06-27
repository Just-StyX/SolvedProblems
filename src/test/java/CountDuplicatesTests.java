import jsl.groups.strings.CountDuplicateCharacters;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CountDuplicatesTests {
    Map<String, Long> map = Map.of(
            "s", 3L, "t", 3L, "a", 1L, "i", 2L, "c", 1L);
    CountDuplicateCharacters duplicates = new CountDuplicateCharacters();

    @Test
    public void checkDuplicate() {
        assertAll(
                () -> assertThat(map).isEqualTo(duplicates.countDuplicates("statistics")),
                () -> assertThat("staic").isEqualTo(duplicates.removeDuplicates("statistics")),
                () -> assertThat("staic is misp").isEqualTo(duplicates.removeDuplicatesOfCharactersInASentence("statistics iss mississippi")),
                () -> assertThat('m').isEqualTo(duplicates.firstNonRepeatedCharacter("mississippi"))
        );
    }
}
