package Lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LostWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        boolean[] gor = new boolean[n];
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
        }
        int rez = permutations(0, n, gor, diag1, diag2, arr);
        System.out.print(rez);

    }

    private static int permutations(int startInd, int finishInd, boolean[] gor, Set<Integer> diag1, Set<Integer> diag2, int[] arr) {
        int count = 0;
        for (int j = startInd; j < finishInd; j++) {
            int s = 0;
            for (int i = 0; i < finishInd; i++) {
                s++;
                if (gor[i] || diag1.contains(i - j) || diag2.contains(i + j)) continue;
                arr[j] = i;
                if (startInd == finishInd-1) {
                    count++;
                    //Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
                    //System.out.println();
                    continue;
                }

                gor[i] = true;
                diag1.add(i - j);
                diag2.add(i + j);

                count += permutations(startInd + 1, finishInd, gor, diag1, diag2, arr);
                arr[j] = -1;
                gor[i] = false;
                diag1.remove(i - j);
                diag2.remove(i + j);
            }

            if (s == finishInd) break;
        }

        return count;
    }
}
