package cleancalculator;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Calculator {

    private final List<Number> numbers;
    private final boolean log;

    private final Operator operator;

    public Calculator(List<Number> numbers, Operator operator, boolean log) {
        this.numbers = numbers;
        this.log = log;
        this.operator = operator;
    }

    public void calculate() {

        if (log) {
            printLog("started");
            printLog("applying operation: " + getOperatorName());
        }

        Number result = numbers.get(0);
        System.out.println(result.toString());

        for (int i = 1; i < numbers.size(); i++) {

            if (log) {
                printLog("Accumulation : " + result + " on line " + i);
                printLog("parsed value = " + numbers.get(i));
            }

            result = applyOperator(operator, result, numbers.get(i));

            System.out.println(getOperatorSymbol() + numbers.get(i) + " (= " + result + ")");
        }

        System.out.println("----------\ntotal = " + result);
    }

    public String getOperatorName() {
        return switch (operator) {
            case ADDITION -> "addition";
            case SUBTRACTION -> "subtraction";
            case MULTIPLICATION -> "multiplication";
            case DIVISION -> "division";
            default -> throw new IllegalArgumentException();
        };
    }

    public String getOperatorSymbol() {
        return switch (operator) {
            case ADDITION -> "+";
            case SUBTRACTION -> "-";
            case MULTIPLICATION -> "*";
            case DIVISION -> "/";
            default -> throw new IllegalArgumentException();
        };
    }

    public Number applyOperator(Operator operator, Number a, Number b) {
        return switch (operator) {
            case ADDITION -> a.doubleValue() + b.doubleValue();
            case SUBTRACTION -> a.doubleValue() - b.doubleValue();
            case MULTIPLICATION -> a.doubleValue() * b.doubleValue();
            case DIVISION -> a.doubleValue() / b.doubleValue();
            default -> throw new IllegalArgumentException();
        };
    }

    public void printLog(String logString) {
        System.out.println(getLogString() + " " + logString);
    }

    public String getLogString() {
        return "[" + DateTimeFormatter.ofPattern("HHmmss:SSSSSS").format(java.time.LocalDateTime.now()) + "][log]";
    }

}
