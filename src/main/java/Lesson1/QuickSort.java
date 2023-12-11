package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String countStr = reader.readLine();
        int count = Integer.parseInt(countStr);

        if(count == 0) {
            System.out.println("");
            return;
        }

        String s = reader.readLine();
        String[] arrStr = s.split(" ");
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int[] rez = partition(arr, 0, arr.length);

        Arrays.stream(rez).forEach(x -> System.out.print(x + " "));

    }

    public static int[] partition(int[] arr, int start, int end) {

        if (start >= end) return arr;

        //int sep = arr[start];
        int rand = (int) (Math.random() * (end-start) + start);
        int sep = arr[rand];
        int e = -1;
        int g = -1;

        for (int i = start; i < end; i++) {
            if (arr[i] < sep) {
                if (g == -1 && e != -1){
                    int x = arr[e];
                    arr[e] = arr[i];
                    arr[i] = x;
                    e++;
                }
                else if (e == -1 && g != -1){
                    int x = arr[g];
                    arr[g] = arr[i];
                    arr[i] = x;
                    g++;
                } else if (e != -1 && g != -1){
                    int x = arr[g];
                    arr[g] = arr[e];
                    arr[e] = arr[i];
                    arr[i] = x;
                    e++;
                    g++;
                }

            } else if (arr[i] == sep) {
                if (e == -1 && g == -1 ) {
                    e = i;
                } else if (e == -1 && g != -1){
                    e = g;
                    int x = arr[g];
                    arr[g] = arr[i];
                    arr[i] = x;
                    g++;
                } else if (e != -1 && g != -1){
                    int x = arr[g];
                    arr[g] = arr[i];
                    arr[i] = x;
                    g++;
                }
            } else if (arr[i] > sep) {
                if (g == -1) {
                    g = i;
                }
            }
        }

        if (e != -1) arr = partition(arr, start, e);

        if (g != -1) arr = partition(arr, g, end);

        return arr;
    }
}

