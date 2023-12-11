package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MiddleLevel {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sizeArr = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] arr = new int[sizeArr];
        for (int i = 0; i < sizeArr; i++) {
            arr[i] = Integer.valueOf(tokenizer.nextToken());
        }

        int[] level = new int[sizeArr];
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0, j = arr.length-1; i < arr.length; i++, j--) {
            level[i] += arr[i] * i - sum1;
            level[j] += sum2 - arr[j] * i;

            sum1 += arr[i];
            sum2 += arr[j];
        }

        for (int i = 0; i < level.length; i++) {
            System.out.print(level[i] + " ");
        }
    }
}

