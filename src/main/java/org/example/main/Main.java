package org.example.main;

import org.apache.commons.cli.CommandLine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        CommandLine cmd = ApacheCommonsCli.getCmd(args);
        //System.out.println(ApacheCommonsCli.getSortType(cmd));


        if(ApacheCommonsCli.getSortType(cmd) && cmd.hasOption("i")) {
            int[] result = new int[]{4, 3, 1, 4, 5, 7, 8, 9, 0, 11, 22};
            System.out.println(Arrays.toString(MergeSortInt2.sortAsc(result)));

            String[] intFiles = ApacheCommonsCli.getFilePaths(cmd);
            for (String fp : intFiles) {
                //String fileName = "/Users/pankaj/source.txt";
                String fileName = fp;
                //File file = new File(fileName);
                File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\org\\example\\main\\" +fp);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                System.out.println("Read text file using BufferedReader");
                while((line = br.readLine()) != null){
                    //process the line
                    System.out.println(line);
                }
                //close resources
                br.close();
                fr.close();
            }
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
            System.out.println(Arrays.toString(MergeSortStrings.getAscSortedStrArr(values)));
            System.out.println("Сработала именно эта ветка");
        }
        else {
            //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
            String[] values = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
            //MergeSortStrings.mergeSortAsc(values, 0, values.length - 1);
            //System.out.println("Result " + Arrays.toString(values));
            System.out.println(Arrays.toString(MergeSortStrings.getDesSortedStrArr(values)));
            System.out.println("Сработала НЕ эта ветка");
        }




    }


}
