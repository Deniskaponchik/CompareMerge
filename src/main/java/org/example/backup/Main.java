//https://stackoverflow.com/questions/367706/how-do-i-parse-command-line-arguments-in-java
//https://commons.apache.org/proper/commons-cli/
package org.example.backup;

import org.apache.commons.cli.*;
import org.example.main.MergeSortInt2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        //ApacheCommonsCli.getSum(String[] args);
        Options options = new Options();

        Option integerFilesOpt = new Option("i", "integer", true, "integer file path");
        //integerFilesOpt.setRequired(false);
        integerFilesOpt.setArgs(Option.UNLIMITED_VALUES);
        integerFilesOpt.setOptionalArg(true);
        integerFilesOpt.setValueSeparator(',');
        //options.addOption(integerFilesOpt);

        Option stringFilesOpt = new Option("s", "string", true, "string file path");
        //stringFilesOpt.setRequired(false);
        stringFilesOpt.setArgs(Option.UNLIMITED_VALUES);
        stringFilesOpt.setOptionalArg(true);
        stringFilesOpt.setValueSeparator(',');
        //options.addOption(stringFilesOpt);

        OptionGroup fileTypeOptGroup = new OptionGroup();
        fileTypeOptGroup.setRequired(true);
        //fileTypeOptGroup.addOption(new Option("i", true, "integer file path"));
        //fileTypeOptGroup.addOption(new Option("s", true, "string file path"));
        fileTypeOptGroup.addOption(integerFilesOpt);
        fileTypeOptGroup.addOption(stringFilesOpt);
        options.addOptionGroup(fileTypeOptGroup);




        Option outputOpt = new Option("out", "output", true, "output file path");
        outputOpt.setRequired(true);
        outputOpt.setOptionalArg(true);
        options.addOption(outputOpt);



        Option ascSortOpt = new Option("a", "ascending", false, "ascending sort");
        ascSortOpt.setRequired(false);
        ascSortOpt.setArgs(0);
        ascSortOpt.setOptionalArg(false);
        options.addOption(ascSortOpt);

        Option desSortOpt = new Option("d", "descending", false, "descending sort");
        desSortOpt.setRequired(false);
        desSortOpt.setArgs(0);
        desSortOpt.setOptionalArg(false);
        options.addOption(desSortOpt);

        OptionGroup sortTypeOptGroup = new OptionGroup();
        sortTypeOptGroup.setRequired(false);
        //sortTypeOptGroup.addOption(new Option("i", true, "integer file path"));
        //sortTypeOptGroup.addOption(new Option("s", true, "string file path"));
        sortTypeOptGroup.addOption(ascSortOpt);
        sortTypeOptGroup.addOption(desSortOpt);
        options.addOptionGroup(sortTypeOptGroup);



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



        //String integerFilePath = cmd.getOptionValue("i");
        String [] integerFilePath = cmd.getOptionValues("i");
        //System.out.println("Integer " + integerFilePath);
        System.out.println(Arrays.toString(integerFilePath));

        //String stringFilePath = cmd.getOptionValue("s");
        String [] stringFilePath = cmd.getOptionValues("s");
        //System.out.println("String " + stringFilePath);
        System.out.println(Arrays.toString(stringFilePath));


        String outputFilePath = cmd.getOptionValue("output");
        System.out.println("Output " + outputFilePath);

        /*
        String ascSort = cmd.getOptionValue("a");
        System.out.println("Sort " + ascSort);
        String descSort = cmd.getOptionValue("d");
        System.out.println("Sort " + descSort);
        */
        if(cmd.hasOption("d")) {
            //String sortKind = cmd.getOptionValue("desSortOpt");
            System.out.println("Has d");
        } else {
            //String sortKind = cmd.getOptionValue("ascSortOpt");
            System.out.println("Has a");
        }





        int [] result = new int[]{4,3,1,4,5,7,8,9,0,11,22};
        System.out.println(Arrays.toString(MergeSortInt2.sort(result)));

    }


}
