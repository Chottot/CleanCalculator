package cleancalculator.cli;

import cleancalculator.Operator;

public class CliParser {

    static public CliParserResult parse(String[] args) {

        if (args.length < 2) {
            System.out.println("Invalid number of arguments");
            throw new IllegalArgumentException();
        }

        String filePath = args[0];
        Operator op = Operator.fromString(args[1]);

        if (op == null) {
            System.out.println("Invalid operator");
            throw new IllegalArgumentException();
        }

        boolean log = false;

        if (args.length == 3) {
            if (args[2].equals("-log")) {
                log = true;
            } else {
                System.out.println("Invalid argument");
                throw new IllegalArgumentException();
            }
        }

        return new CliParserResult(op, filePath, log);
    }

}
