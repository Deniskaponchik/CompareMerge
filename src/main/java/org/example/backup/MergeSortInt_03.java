//https://javarush.com/quests/lectures/questharvardcs50.level03.lecture11
//Тимур Шамилов Уровень 35
package org.example.backup;
import java.util.Arrays;

public class MergeSortInt_03 {
    //public int [] result;
    /*
    public static void main(String[] args) {
        int [] result = new int[]{4,3,1,4,5,7,8,9,0,11,22};
        int[] sort = sort(result);
        System.out.println("Result " + Arrays.toString(sort));
        //for (int i = 0; i < result.length; i++) {          System.out.println(sort[i]);        }
    }   */

    public static int[] sortAsc(int[] result) {
        if (result.length < 2) {
            return result;
        } else {
            int[] left = sortAsc(Arrays.copyOfRange(result,0, result.length/2));
            int[] right = sortAsc(Arrays.copyOfRange(result,result.length / 2, result.length));
            return mergeAsc(left ,right);
        }
    }
    private static int[] mergeAsc(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        if (i == left.length) {
            while (j < right.length) {
                result[k] = right[j];
                j++;k++;
            }
        }
        if (j == right.length) {
            while (i < left.length) {
                result[k] = left[i];
                i++;k++;
            }
        }
        return result;
    }




    public static int[] sortDes(int[] result) {
        if (result.length < 2) {  //если число элементов во входном массиве меньше 2 - возвращаем
            return result;
        } else {
            int[] left = sortDes(Arrays.copyOfRange(result,0, result.length/2));
            int[] right = sortDes(Arrays.copyOfRange(result,result.length / 2, result.length));
            return mergeDes(left ,right);
        }
    }
    private static int[] mergeDes(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            //if (left[i] < right[j]) {
            if (left[i] > right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        if (i == left.length) {
            while (j < right.length) {
                result[k] = right[j];
                j++;k++;
            }
        }
        if (j == right.length) {
            while (i < left.length) {
                result[k] = left[i];
                i++;k++;
            }
        }
        return result;
    }









}
