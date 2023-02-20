package org.example.main;
import java.util.Arrays;
public class MergeSortInt {

    public static int[] sort(int[] result, boolean sortType) {
        if (result.length < 2) {
            return result;
        } else {
            int[] left = sort(Arrays.copyOfRange(result,0, result.length/2), sortType);
            int[] right = sort(Arrays.copyOfRange(result,result.length / 2, result.length), sortType);
            return merge(left ,right, sortType);
        }
    }
    private static int[] merge(int[] left, int[] right, boolean sortType) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (sortType) {
                if (left[i] < right[j]) {  //для прямой сортировки
                //if (left[i] > right[j]) {  // для обратной сортировки
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }
            } else {
                //if (left[i] < right[j]) {  //для прямой сортировки
                if (left[i] > right[j]) {  // для обратной сортировки
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }
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
