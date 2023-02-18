package org.example.backup;

import org.apache.commons.cli.CommandLine;
import org.example.main.ApacheCommonsCli;
import org.example.main.MergeSortInt;
import org.example.main.MergeSortStrings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) throws Exception {
        CommandLine cmd = org.example.main.ApacheCommonsCli.getCmd(args);
        //System.out.println(ApacheCommonsCli_01.getSortType(cmd));
        String[] filesNames = org.example.main.ApacheCommonsCli.getFilePaths(cmd);

        ArrayList<Integer> unsoredIntArr = new ArrayList<>();
        ArrayList<String> unsoredStrArr = new ArrayList<>();

        for (String fp : filesNames) {
            //String fileName = "/Users/pankaj/source.txt";
            String fileName = fp;

            try { //пытаемся получить файлы из текущей директории
                //File file = new File(fileName);
                File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\main\\" + fp);
                //File file = new File(System.getProperty("user.dir")+fp);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;

                try { //пытаемся прочитать строки из файлов
                    while ((line = br.readLine()) != null) {

                        if (cmd.hasOption("i")) {
                                                        //process the line
                            System.out.println(line);

                            try {  //Проверить на интегер
                                int integer = Integer.parseInt(line);
                                unsoredIntArr.add(integer);
                            } catch (Exception e) {
                                System.out.println("Взятая строка НЕ integer");
                            }

                        }


                    }

                    //close resources
                    br.close();
                    fr.close();
                } catch (Exception e) {
                    System.out.println("Не удалось прочитать файл");
                }
            } catch (Exception e) {
                System.out.println("не удалось получить файлы");
            }
        }







        if(org.example.main.ApacheCommonsCli.getSortType(cmd) && cmd.hasOption("i")) {
            int[] result = new int[]{4, 3, 1, 4, 5, 7, 8, 9, 0, 11, 22};
            System.out.println(Arrays.toString(MergeSortInt.sortAsc(result)));

            String[] intFiles = org.example.main.ApacheCommonsCli.getFilePaths(cmd);
            for (String fp : intFiles) {
                //String fileName = "/Users/pankaj/source.txt";
                String fileName = fp;
                //File file = new File(fileName);
                File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\org\\example\\main\\" +fp);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null){
                    //process the line
                    System.out.println(line);
                }
                //close resources
                br.close();
                fr.close();
            }
        }


        else if(!org.example.main.ApacheCommonsCli.getSortType(cmd) && cmd.hasOption("i")){
            int[] result = new int[]{4, 3, 1, 4, 5, 7, 8, 9, 0, 11, 22};
            System.out.println(Arrays.toString(MergeSortInt.sortDes(result)));
        }
        else if(ApacheCommonsCli.getSortType(cmd) && cmd.hasOption("s")){
            //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
            String[] values = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
            //MergeSortStrings_01.mergeSortAsc(values, 0, values.length - 1);
            //System.out.println("Result " + Arrays.toString(values));
            System.out.println(Arrays.toString(org.example.main.MergeSortStrings.getAscSortedStrArr(values)));
            System.out.println("Сработала именно эта ветка");
        }
        else {
            //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
            String[] values = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
            //MergeSortStrings_01.mergeSortAsc(values, 0, values.length - 1);
            //System.out.println("Result " + Arrays.toString(values));
            System.out.println(Arrays.toString(MergeSortStrings.getDesSortedStrArr(values)));
            System.out.println("Сработала НЕ эта ветка");
        }




    }


}
