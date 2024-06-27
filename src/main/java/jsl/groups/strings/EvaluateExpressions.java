package jsl.groups.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Evaluate expressions.
 *
 * @author github.com/Just-StyX
 */
public class EvaluateExpressions {
    /**
     * Evaluate double. Evaluation is from left to right. PEMDAS ( or BODMAS ) is not taking into consideration
     *
     * @param expression the expression
     * @return the evaluated expression
     */
    public double evaluate(String expression) {
        List<Double> operands = Arrays.stream(expression.split("[-+*/]")).map(Double::valueOf).toList();
        List<String> operationList = new ArrayList<>();
        var operations = "+-*/";
        for (String str: expression.split("")) {
            if (operations.contains(str)) operationList.add(str);
        }
        double total = operands.getFirst();
        for (int i = 0; i < operationList.size(); i++) {
            switch (operationList.get(i)) {
                case "-" -> total -= operands.get(i + 1);
                case "*" -> total *= operands.get(i + 1);
                case "/" -> total /= operands.get(i + 1);
                default -> total += operands.get(i + 1);
            }
        }
        return total;
    }
}
