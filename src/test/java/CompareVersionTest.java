import jsl.groups.strings.CompareVersions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CompareVersionTest {
    CompareVersions comparison = new CompareVersions();

    @Test
    public void compareVersions() {
        assertAll(
                () -> assertThat(0).isEqualTo(comparison.compare("1.1.1", "1.1.1")),
                () -> assertThat(-1).isEqualTo(comparison.compare("2.3.1", "2.4")),
                () -> assertThat(1).isEqualTo(comparison.compare("1.5.2", "1.5.1"))
        );
    }
}
