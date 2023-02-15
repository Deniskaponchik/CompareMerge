package org.example.backup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Max {

    //task0532;
    public static void main(String[] args) throws Exception {
        BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufread.readLine());
        //int[] numbers[] = {};
        //напишите тут ваш код
        if ( N > 0 ) {
            int maximum = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                int number = Integer.parseInt(bufread.readLine());
                maximum = number > maximum ? number : maximum;
            }
            System.out.println(maximum);
        }
    }
}
