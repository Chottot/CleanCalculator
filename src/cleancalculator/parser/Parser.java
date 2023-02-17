package cleancalculator.parser;

import java.io.BufferedReader;
import java.util.List;

public interface Parser {

    List<Number> parse(BufferedReader reader);
}
