package Lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TravelingSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        Set<Integer> notVisited = new HashSet<>();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
            notVisited.add(i);
        }
        int rez = 0;
        if(arr.length > 1) rez = path(arr, notVisited, 0, -1, 0, "");

        System.out.print(rez);
    }

    private static int path(int[][] arr, Set<Integer> notVisited, int rez, int bestRez, int j, String str) {
        //str += j;
        notVisited.remove(j);
        if(notVisited.isEmpty()) {
            if (arr[0][j] != 0) {
                rez += arr[0][j];
            } else {
                //System.out.println(bestRez + ": " + str);
                notVisited.add(j);
                return bestRez;
            }

            if (bestRez == -1) {
                //System.out.println(rez + ": " + str);
                notVisited.add(j);
                return rez;
            } else {
                bestRez = Math.min(rez, bestRez);
                //System.out.println(bestRez + ": " + str);
                notVisited.add(j);
                return bestRez;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][j] != 0 && notVisited.contains(i)) {
                rez += arr[i][j];
                if ((rez < bestRez && bestRez != -1) || bestRez == -1) {
                    bestRez = path(arr, notVisited, rez, bestRez, i, str);
                }
                rez -= arr[i][j];
            }
        }

        notVisited.add(j);

        return bestRez;
    }
}