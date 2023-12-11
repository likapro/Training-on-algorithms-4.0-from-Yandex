package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sizeArrStr = reader.readLine();
        int sizeArr = Integer.parseInt(sizeArrStr);
        int[] arr = new int[sizeArr];
        String n = reader.readLine();
        String[] arrStr = n.split(" ");
        for (int i = 0; i < sizeArr; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        if (sizeArr == 0) {
            System.out.println("");
            return;
        }

        int[] rez = mergeSort(arr, 0, arr.length-1);
        for (int i = 0; i < rez.length; i++) {
            System.out.print(rez[i] + " ");
        }
    }

    private static int[] mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r)/2;
            arr = merge(mergeSort(arr, l, m), mergeSort(arr, m+1, r));
        } else {
            return new int[] {arr[l]};
        }

        return arr;
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];

        int n = 0, m = 0, i = 0;
        while (n < arr1.length && m < arr2.length) {
            if (arr1[n] < arr2[m]) {
                arr[i++] = arr1[n++];
            } else {
                arr[i++] = arr2[m++];
            }
        }

        if(n == arr1.length) {
            while (m < arr2.length) {
                arr[i++] = arr2[m++];
            }
        } else if (m == arr2.length) {
            while (n < arr1.length) {
                arr[i++] = arr1[n++];
            }
        }

        return arr;
    }
}


