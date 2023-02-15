package org.example.backup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinFrom5numbers {

    //task0531
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        //int minimum = min(a, b);
        /*
        int minAB = min(a, b);
        int minCD = min(c, d);
        int minABCD = min(minAB, minCD);
        int minABCDE = min(minABCD, e);
        */
        int minimum = min(a, b, c, d, e);
        System.out.println("Minimum = " + minimum);
    }

    /*
    public static int min(int a, int b) {
        return a < b ? a : b;
    }*/
    public static int min(int a, int b, int c, int d, int e) {
        int minAB = a < b ? a : b;
        int minCD = c < d ? c : d;
        int minABCD = minAB < minCD ? minAB : minCD;
        return minABCD < e ? minABCD : e;
        //return a < b ? a : b;


    }

}
