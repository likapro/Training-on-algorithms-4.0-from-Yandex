package Lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPermutations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        permutations("" , arr);

    }

    private static void permutations(String str, int[] arr) {
        if (arr.length == 1) {
            System.out.println(str + arr[0]);
        } else {
            for (int i = 0; i < arr.length; i++) {
                String strCurr = str + arr[i];

                int[] arrCurr = new int[arr.length-1];
                for (int j = 0, k = 0; j < arrCurr.length; k++) {
                    if (i == k) continue;

                    arrCurr[j] = arr[k];
                    j++;
                }

                permutations(strCurr, arrCurr);
            }
        }
    }
}
