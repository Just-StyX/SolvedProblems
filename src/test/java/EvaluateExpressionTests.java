import jsl.groups.strings.EvaluateExpressions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class EvaluateExpressionTests {
    EvaluateExpressions evaluateExpressions = new EvaluateExpressions();
    @Test
    public void setEvaluateExpressions() {
        assertAll(
                () -> assertThat(0.0).isEqualTo(evaluateExpressions.evaluate("0/1")),
                () -> assertThat(3.0).isEqualTo(evaluateExpressions.evaluate("6+9-12")),
                () -> assertThat(6.0).isEqualTo(evaluateExpressions.evaluate("6+9-12*2")),
                () -> assertThat(17.0).isEqualTo(evaluateExpressions.evaluate("17"))
        );
    }
}
