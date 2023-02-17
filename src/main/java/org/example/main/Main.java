package org.example.main;

import org.apache.commons.cli.CommandLine;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        CommandLine cmd = ApacheCommonsCli.getCmd(args);
        //System.out.println(ApacheCommonsCli.getSortType(cmd));
        String[] filesNames = ApacheCommonsCli.getFilePaths(cmd);

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


        //FileOutputStream out = new FileOutputStream("the-file-name");
        //FileOutputStream out = new FileOutputStream(ApacheCommonsCli.getOutFilePath(cmd));
        BufferedWriter outputWriter = null;
        //outputWriter = new BufferedWriter(new FileWriter(ApacheCommonsCli.getOutFilePath(cmd)));
        outputWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\main\\" + ApacheCommonsCli.getOutFilePath(cmd)));
        try {
            //ОТСОРТИРОВАТЬ
            if (cmd.hasOption("i")) {
                int[] unsortedIntArr = unsoredIntArrList.stream().mapToInt(i -> i).toArray();
                if (ApacheCommonsCli.getSortType(cmd)) {
                    int[] sortedIntArr = MergeSortInt2.sortAsc(unsortedIntArr);
                    //System.out.println(Arrays.toString(sortedIntArr));
                    for (int i = 0; i < sortedIntArr.length; i++) {
                        outputWriter.write(Integer.toString(sortedIntArr[i]));
                        outputWriter.newLine();
                    }
                } else {
                    int[] sortedIntArr = MergeSortInt2.sortDes(unsortedIntArr);
                    //System.out.println(Arrays.toString(sortedIntArr));
                    for (int i = 0; i < sortedIntArr.length; i++) {
                        outputWriter.write(Integer.toString(sortedIntArr[i]));
                        outputWriter.newLine();
                    }
                }




            } else {
                String[] unsortedStrArr = unsoredStrArrList.toArray(new String[unsoredStrArrList.size()]);
                if (ApacheCommonsCli.getSortType(cmd)) {
                    String[] sortedStrArr = MergeSortStrings.getAscSortedStrArr(unsortedStrArr);
                    //System.out.println(Arrays.toString(sortedStrArr));
                    for (int i = 0; i < sortedStrArr.length; i++) {
                        outputWriter.write(sortedStrArr[i]+"");
                        outputWriter.newLine();
                    }
                } else {
                    String[] sortedStrArr = MergeSortStrings.getDesSortedStrArr(unsortedStrArr);
                    //System.out.println(Arrays.toString(sortedStrArr));
                    for (int i = 0; i < sortedStrArr.length; i++) {
                        outputWriter.write(sortedStrArr[i]+"");
                        outputWriter.newLine();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("не удалось записать данные в итоговый файл");
        } finally {
            //out.close();
            outputWriter.flush();
            outputWriter.close();
        }
        /*
        String[] unsortedStrArr = unsoredStrArrList.toArray(new String[unsoredStrArrList.size()]);
        //String[] unsortedStrArr = unsoredStrArrList.stream().toList(i -> i).toArray();
        int[] unsortedIntArr = unsoredIntArrList.stream().mapToInt(i -> i).toArray();
        //System.out.println(unsortedIntArr.toString());
        //System.out.println(unsortedStrArr.toString());

        String[] sortedStrArr = MergeSortStrings.getAscSortedStrArr(unsortedStrArr);
        int[] sortedIntArr = MergeSortInt2.sortAsc(unsortedIntArr);

        System.out.println(Arrays.toString(sortedIntArr));
        System.out.println(Arrays.toString(sortedStrArr));
         */

        //ВЫГРУЗИТЬ В OUT







        /*
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
        */




    }


}
