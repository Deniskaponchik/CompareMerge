//https://stackoverflow.com/questions/23064247/java-mergesort-with-strings
package org.example.main;

public class MergeSortStrings {
    /* рабочий код. не трогать
    public static void main(String[] args) {
        //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
        String[] values = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
        mergeSort(values, 0, values.length - 1);
        System.out.println("Result " + Arrays.toString(values));
    }  */

    public static String[] getAscSortedStrArr(String[] values) {
        //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
        //String[] values = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
        mergeSortAsc(values, 0, values.length - 1);
        //System.out.println("Result " + Arrays.toString(values));
        return values;
    }

    public static void mergeSortAsc(String[] a, int from, int to) {
        if (from == to) {
            return;
            //return a; // ??? ПОДУМАТЬ, правильно ли
        }
        int mid = (from + to) / 2;
        // sort the first and the second half
        mergeSortAsc(a, from, mid);
        mergeSortAsc(a, mid + 1, to);
        mergeAsc(a, from, mid, to);

       // return a; /// ????
    }
    public static void mergeAsc(String[] a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[] b = new String[n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }
        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }
        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }





    public static String[] getDesSortedStrArr(String[] values) {
        //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
        //String[] values = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
        mergeSortDes(values, 0, values.length - 1);
        //System.out.println("Result " + Arrays.toString(values));
        return values;
    }
    public static void mergeSortDes(String[] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // sort the first and the second half
        mergeSortDes(a, from, mid);
        mergeSortDes(a, mid + 1, to);
        mergeDes(a, from, mid, to);
    }
    public static void mergeDes(String[] a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[] b = new String[n];  // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }
        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }
        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }






}
