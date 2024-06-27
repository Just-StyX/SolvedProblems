import jsl.groups.strings.Permutation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PermutationTest {
    Permutation permutation = new Permutation();

    @Test
    public void setPermutation() {
        var list = List.of("abc", "acb", "bca", "bac", "cab", "cba");
        assertAll(
                () -> assertThat(permutation.factorial("abc".length())).isEqualTo(permutation.permutation("abc").size()),
                () -> assertThat(list).containsExactlyElementsOf(permutation.permutation("abc"))
        );
    }
}
