package org.example.main;
import org.apache.commons.cli.CommandLine;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        CommandLine cmd = ApacheCommonsCli.getCmd(args);
        //System.out.println(ApacheCommonsCli.getSortType(cmd));
        String[] filesNames = ApacheCommonsCli.getFilePaths(cmd);
        String outFile = ApacheCommonsCli.getOutFilePath(cmd);
        Boolean sortType = ApacheCommonsCli.getSortType(cmd);


        ArrayList<Integer> unsoredIntArrList = new ArrayList<>();
        ArrayList<String> unsoredStrArrList = new ArrayList<>();


        for (String fp : filesNames) {
            //String fileName = "/Users/admin/source.txt";
            //String fileName = fp;

            try { //пытаемся получить файлы из текущей директории
                System.out.println(" ");

                File file;
                if(isDevelopmentEnvironment()) { //проверка на запуск кода в IDEA или нет
                    file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\main\\" + fp);
                } else {
                    file = new File(System.getProperty("user.dir") + "\\" + fp);
                }
                System.out.println(file.toString());

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

                } catch (Exception e) {
                    System.out.println("Не удалось прочитать файл");
                } finally {
                    br.close();
                    fr.close();
                }
            } catch (Exception e) {
                System.out.println("не удалось получить файлы");
            }
        }
        //System.out.println(unsoredStrArr.toString());
        //System.out.println(unsoredIntArr.toString());


        System.out.println(" ");
        //BufferedWriter outputWriter = null;
        BufferedWriter outputWriter;
        if(isDevelopmentEnvironment()) { //проверка на запуск в IDEA или нет
            //outputWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\main\\" + ApacheCommonsCli.getOutFilePath(cmd)));
            outputWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\main\\" + outFile));

        } else {
            //outputWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\" + ApacheCommonsCli.getOutFilePath(cmd)));
            outputWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\" + outFile));
        }
        try {
            if (cmd.hasOption("i")) {  //Сортировка числового массива
                int[] unsortedIntArr = unsoredIntArrList.stream().mapToInt(i -> i).toArray();
                int[] sortedIntArr = MergeSortInt.sort(unsortedIntArr, sortType);
                //System.out.println(Arrays.toString(sortedIntArr));
                for (int i = 0; i < sortedIntArr.length; i++) {
                    outputWriter.write(Integer.toString(sortedIntArr[i]));
                    outputWriter.newLine();
                }

            } else { //Сортировка строкового массива
                String[] unsortedStrArr = unsoredStrArrList.toArray(new String[unsoredStrArrList.size()]);
                String[] sortedStrArr = MergeSortStrings.getSortedStrArr(unsortedStrArr, sortType);
                //System.out.println(Arrays.toString(sortedStrArr));
                for (int i = 0; i < sortedStrArr.length; i++) {
                    outputWriter.write(sortedStrArr[i] + "");
                    outputWriter.newLine();
                }
            }

                /*
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
                } */


        } catch (Exception e) {
            System.out.println("не удалось записать данные в итоговый файл");
        } finally {
            //out.close();
            outputWriter.flush();
            outputWriter.close();
        }


    }

    //проверка на запуск кода в IDEA или нет
    public static boolean isDevelopmentEnvironment() {
        boolean isIDEA = true;
        if (System.getenv("isIDEA") == null) {
            isIDEA = false;
        }
        return isIDEA;
    }


}
