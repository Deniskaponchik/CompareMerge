package org.example.backup;
public class QsortInt {

    public static void sort(int[] a) {
        qsort(a, 0, a.length);
        }
      /**
     1722:    * Performs a stable sort on the elements, arranging them according to their
     1723:    * natural order.
     1724:    *
     1725:    * @param a the int array to sort
     1726:    * @param fromIndex the first index to sort (inclusive)
     1727:    * @param toIndex the last index to sort (exclusive)
     1728:    * @throws IllegalArgumentException if fromIndex &gt; toIndex
     1729:    * @throws ArrayIndexOutOfBoundsException if fromIndex &lt; 0 || toIndex &gt; a.length
     1731:    */

    public static void sort(int[] a, int fromIndex, int toIndex) {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();
        if (fromIndex < 0)
            throw new ArrayIndexOutOfBoundsException();
        qsort(a, fromIndex, toIndex - fromIndex);
        }

        /**
 1742:    * Finds the index of the median of three array elements.
 1743:    *
 1744:    * @param a the first index
 1745:    * @param b the second index
 1746:    * @param c the third index
 1747:    * @param d the array
 1748:    * @return the index (a, b, or c) which has the middle value of the three
 1749:    */
        private static int med3(int a, int b, int c, int[] d) {
        return (d[a] < d[b]
        ? (d[b] < d[c] ? b : d[a] < d[c] ? c : a)
        : (d[b] > d[c] ? b : d[a] > d[c] ? c : a));
        }
        /**
 1758:    * Swaps the elements at two locations of an array
 1759:    *
 1760:    * @param i the first index
 1761:    * @param j the second index
 1762:    * @param a the array
 1763:    */
        private static void swap(int i, int j, int[] a) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
        }
/**
 1772:    * Swaps two ranges of an array.
 1773:    *
 1774:    * @param i the first range start
 1775:    * @param j the second range start
 1776:    * @param n the element count
 1777:    * @param a the array
 1778:    */
        private static void vecswap(int i, int j, int n, int[] a) {
        for ( ; n > 0; i++, j++, n--)
            swap(i, j, a);
        }
/**
 1786:    * Compares two integers in natural order, since a - b is inadequate.
 1787:    *
 1788:    * @param a the first int
 1789:    * @param b the second int
 1790:    * @return &lt; 0, 0, or &gt; 0 accorting to the comparison
 1791:    */
        private static int compare(int a, int b) {
        return a < b ? -1 : a == b ? 0 : 1;
        }
    /**
     1798:    * Performs a recursive modified quicksort.
     1799:    *
     1800:    * @param array the array to sort
     1801:    * @param from the start index (inclusive)
     1802:    * @param count the number of elements to sort
     1803:    */

    private static void qsort(int[] array, int from, int count) {
        // Use an insertion sort on small arrays.
        if (count <= 7) {
            for (int i = from + 1; i < from + count; i++)
                for (int j = i; j > from && array[j - 1] > array[j]; j--)
                    swap(j, j - 1, array);
            return;
        }
        // Determine a good median element.
        int mid = count / 2;
        int lo = from;
        int hi = from + count - 1;
        if (count > 40) { // big arrays, pseudomedian of 9
            int s = count / 8;
            lo = med3(lo, lo + s, lo + 2 * s, array);
            mid = med3(mid - s, mid, mid + s, array);
            hi = med3(hi - 2 * s, hi - s, hi, array);
            }
        mid = med3(lo, mid, hi, array);
        int a, b, c, d;
        int comp;
        // Pull the median element out of the fray, and use it as a pivot.
        swap(from, mid, array);
        a = b = from;
        c = d = from + count - 1;
        // Repeatedly move b and c to each other, swapping elements so
        // that all elements before index b are less than the pivot, and all
        // elements after index c are greater than the pivot. a and b track
        // the elements equal to the pivot.
        while (true) {
            while (b <= c && (comp = compare(array[b], array[from])) <= 0) {
                if (comp == 0) {
                    swap(a, b, array);
                    a++;
                    }
                b++;
            }
            while (c >= b && (comp = compare(array[c], array[from])) >= 0) {
                if (comp == 0) {
                    swap(c, d, array);
                    d--;
                    }
                c--;
                }
            if (b > c)
                break;
            swap(b, c, array);
            b++;
            c--;
            }
        // Swap pivot(s) back in place, the recurse on left and right sections.
        hi = from + count;
        int span;
        span = Math.min(a - from, b - a);
        vecswap(from, b - span, span, array);
        span = Math.min(d - c, hi - d - 1);
        vecswap(b, hi - span, span, array);
        span = b - a;
        if (span > 1)
            qsort(array, from, span);
        span = d - c;
       if (span > 1)
            qsort(array, hi - span, span);
       }


}
