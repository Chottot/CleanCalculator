package cleancalculator.parser;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileParser implements Parser {

    public List<Number> parse(BufferedReader reader) {
        List<Number> numbers = new ArrayList<>();
        reader.lines().forEach(line -> {
            numbers.add(Double.parseDouble(line));
        });
        return numbers;
    }
}
