package cleancalculator.cli;

import cleancalculator.Operator;

public record CliParserResult(Operator op, String filePath, boolean log) {

}
