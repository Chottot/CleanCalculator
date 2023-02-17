import cleancalculator.Calculator;
import cleancalculator.cli.CliParser;
import cleancalculator.cli.CliParserResult;
import cleancalculator.parser.FileParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CliParserResult result = CliParser.parse(args);

        FileParser parser = new FileParser();
        List<Number> numbers = parser.parse(new BufferedReader(new FileReader(result.filePath())));

        Calculator calculator = new Calculator(numbers, result.op(), result.log());
        calculator.calculate();

    }
}