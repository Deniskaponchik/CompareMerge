//https://stackoverflow.com/questions/367706/how-do-i-parse-command-line-arguments-in-java
//https://commons.apache.org/proper/commons-cli/

package org.example.main;
import org.apache.commons.cli.*;

public class ApacheCommonsCli {
    public static void main(String[] args) throws ParseException {
      //public static void printOptions(String[] args) throws Exception {

        Options options = new Options();
        Option input = new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("o", "output", true, "output file");
        output.setRequired(true);
        options.addOption(output);
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;//not a good practice, it serves it purpose

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        String inputFilePath = cmd.getOptionValue("input");
        String outputFilePath = cmd.getOptionValue("output");

        System.out.println("Apache input file " + inputFilePath);
        System.out.println("Apache output file " + outputFilePath);
        //System.out.println(getSum(args));

    }
/*
    public static int getSum(String[] args) {
        int sum = 0;
        for(int i = 1; i < args.length ; i++) {
            sum += Integer.parseInt(args[i]);
        }
        return sum;
    }

    public static int getMultiplication(String[] args) {
        int multiplication = 1;
        for(int i = 1; i < args.length ; i++) {
            multiplication *= Integer.parseInt(args[i]);
        }
        return multiplication;
    }

 */



}
