package Lesson1;

import java.io.*;
import java.util.*;

public class Partition {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String countStr = reader.readLine();
        int count = Integer.parseInt(countStr);
        String s = reader.readLine();
        String[] arrStr = s.split(" ");
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        String sepStr = reader.readLine();
        int sep = Integer.parseInt(sepStr);

        int rez = partition(arr, sep);
        System.out.println(rez);
        System.out.println(count-rez);

    }

    public static int partition(int[] arr, int sep) {
        int rez = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < sep) {
                int x = arr[i];
                arr[i] = arr[rez];
                arr[rez] = x;
                rez++;
            }
        }
        return rez;
    }
}

