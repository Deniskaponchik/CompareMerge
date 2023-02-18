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

public class Main2 {
    public static void main(String[] args) throws Exception {
        CommandLine cmd = org.example.main.ApacheCommonsCli.getCmd(args);
        //System.out.println(ApacheCommonsCli_01.getSortType(cmd));
        String[] filesNames = org.example.main.ApacheCommonsCli.getFilePaths(cmd);

        ArrayList<Integer> unsoredIntArrList = new ArrayList<>();
        ArrayList<String> unsoredStrArrList = new ArrayList<>();

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
                        //System.out.println(line);
                        if (cmd.hasOption("i")) {
                            try {  //Проверить на интегер
                                int integer = Integer.parseInt(line);
                                unsoredIntArrList.add(integer);
                            } catch (Exception e) {
                                System.out.println("Взятая строка НЕ integer");
                            }
                        } else { //если входные файлы со строками
                            if(line.contains(" ")){
                                System.out.println("Строка содержит пробел");
                            } else {
                                unsoredStrArrList.add(line);
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
        //System.out.println(unsoredStrArr.toString());
        //System.out.println(unsoredIntArr.toString());


        //ОТСОРТИРОВАТЬ
        if(cmd.hasOption("i")) {
            int[] unsortedIntArr = unsoredIntArrList.stream().mapToInt(i -> i).toArray();
            if(org.example.main.ApacheCommonsCli.getSortType(cmd)) {
                int[] sortedIntArr = MergeSortInt.sortAsc(unsortedIntArr);
                System.out.println(Arrays.toString(sortedIntArr));
                //ОТПРАВИТЬ В ИТОГОВЫЙ ФАЙЛ
            } else {
                int[] sortedIntArr = MergeSortInt.sortDes(unsortedIntArr);
                System.out.println(Arrays.toString(sortedIntArr));
                //ОТПРАВИТЬ В ИТОГОВЫЙ ФАЙЛ
            }
        }
        else {
            String[] unsortedStrArr = unsoredStrArrList.toArray(new String[unsoredStrArrList.size()]);
            if(ApacheCommonsCli.getSortType(cmd)) {
                String[] sortedStrArr = org.example.main.MergeSortStrings.getAscSortedStrArr(unsortedStrArr);
                System.out.println(Arrays.toString(sortedStrArr));
                //ОТПРАВИТЬ В ИТОГОВЫЙ ФАЙЛ
            } else {
                String[] sortedStrArr = MergeSortStrings.getDesSortedStrArr(unsortedStrArr);
                System.out.println(Arrays.toString(sortedStrArr));
                //ОТПРАВИТЬ В ИТОГОВЫЙ ФАЙЛ
            }
        }
        /*
        String[] unsortedStrArr = unsoredStrArrList.toArray(new String[unsoredStrArrList.size()]);
        //String[] unsortedStrArr = unsoredStrArrList.stream().toList(i -> i).toArray();
        int[] unsortedIntArr = unsoredIntArrList.stream().mapToInt(i -> i).toArray();
        //System.out.println(unsortedIntArr.toString());
        //System.out.println(unsortedStrArr.toString());

        String[] sortedStrArr = MergeSortStrings_01.getAscSortedStrArr(unsortedStrArr);
        int[] sortedIntArr = MergeSortInt_02.sortAsc(unsortedIntArr);

        System.out.println(Arrays.toString(sortedIntArr));
        System.out.println(Arrays.toString(sortedStrArr));
         */

        //ВЫГРУЗИТЬ В OUT







        /*
        if(ApacheCommonsCli_01.getSortType(cmd) && cmd.hasOption("i")) {
            int[] result = new int[]{4, 3, 1, 4, 5, 7, 8, 9, 0, 11, 22};
            System.out.println(Arrays.toString(MergeSortInt_02.sortAsc(result)));

            String[] intFiles = ApacheCommonsCli_01.getFilePaths(cmd);
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


        else if(!ApacheCommonsCli_01.getSortType(cmd) && cmd.hasOption("i")){
            int[] result = new int[]{4, 3, 1, 4, 5, 7, 8, 9, 0, 11, 22};
            System.out.println(Arrays.toString(MergeSortInt_02.sortDes(result)));
        }
        else if(ApacheCommonsCli_01.getSortType(cmd) && cmd.hasOption("s")){
            //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
            String[] values = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
            //MergeSortStrings_01.mergeSortAsc(values, 0, values.length - 1);
            //System.out.println("Result " + Arrays.toString(values));
            System.out.println(Arrays.toString(MergeSortStrings_01.getAscSortedStrArr(values)));
            System.out.println("Сработала именно эта ветка");
        }
        else {
            //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
            String[] values = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
            //MergeSortStrings_01.mergeSortAsc(values, 0, values.length - 1);
            //System.out.println("Result " + Arrays.toString(values));
            System.out.println(Arrays.toString(MergeSortStrings_01.getDesSortedStrArr(values)));
            System.out.println("Сработала НЕ эта ветка");
        }
        */




    }


}
