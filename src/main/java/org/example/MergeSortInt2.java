//https://javarush.com/quests/lectures/questharvardcs50.level03.lecture11
//Тимур Шамилов Уровень 35
package org.example;
import java.util.Arrays;
public class MergeSortInt2 {

    public static void main(String[] args) {
        int [] result = new int[]{4,3,1,4,5,7,8,9,0,11,22};
        int[] sort = sort(result);
        System.out.println("Result " + Arrays.toString(sort));
        //for (int i = 0; i < result.length; i++) {          System.out.println(sort[i]);        }
    }

    private static int[] sort(int[] result) {
        if (result.length < 2) {
            return result;
        } else {
            int[] left = sort(Arrays.copyOfRange(result,0, result.length/2));
            int[] right = sort(Arrays.copyOfRange(result,result.length / 2, result.length));
            return merge(left ,right);
        }
    }

    private static int[] merge(int[] left, int[] right) {
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

}
