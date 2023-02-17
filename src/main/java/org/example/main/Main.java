package org.example.main;
import org.apache.commons.cli.CommandLine;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        CommandLine cmd = ApacheCommonsCli.getCmd(args);
        System.out.println(ApacheCommonsCli.getSortType(cmd));



        if(ApacheCommonsCli.getSortType(cmd) && cmd.hasOption("i")) {
            int[] result = new int[]{4, 3, 1, 4, 5, 7, 8, 9, 0, 11, 22};
            System.out.println(Arrays.toString(MergeSortInt2.sortAsc(result)));
        }
        else if(!ApacheCommonsCli.getSortType(cmd) && cmd.hasOption("i")){
            int[] result = new int[]{4, 3, 1, 4, 5, 7, 8, 9, 0, 11, 22};
            System.out.println(Arrays.toString(MergeSortInt2.sortDes(result)));
        }
        else if(ApacheCommonsCli.getSortType(cmd) && cmd.hasOption("s")){
            //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
            String[] values = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
            //MergeSortStrings.mergeSortAsc(values, 0, values.length - 1);
            //System.out.println("Result " + Arrays.toString(values));
            System.out.println(Arrays.toString(MergeSortStrings.mergeSortAsc(values, 0, values.length - 1)));
        }
        else {

        }




    }


}
