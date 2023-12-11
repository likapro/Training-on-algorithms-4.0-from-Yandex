package Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DijkstraWithPath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Scanner scanner = new Scanner(str);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int f = scanner.nextInt();

        String[] arr = new String[n+1];
        int[][] arrPars = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = reader.readLine();
        }

        boolean[] flag = new boolean[n+1];
        flag[s] = true;
        int[] path = new int[n+1];
        int[] table = new int[n+1];

        scanner = new Scanner(arr[s]);
        for (int j = 0; j <= n; j++) {
            if (j == 0) {
                arrPars[s][j] = 0;
            } else {
                arrPars[s][j] = scanner.nextInt();
            }
        }

        for (int j = 1; j <= n; j++) {
            int k = arrPars[s][j];
            table[j] = k;

            if (k > 0) {
                path[j] = s;
            }
        }

        while (true) {
            int i = -1;
            for (int j = 1; j <= n; j++) {
                if (i == -1 && !flag[j] && table[j] > 0) {
                    i = j;
                } else if (!flag[j] && table[j] > 0 && table[j] < table[i]) {
                    i = j;
                }
            }

            if (i == -1) break;

            scanner = new Scanner(arr[i]);
            for (int t = 0; t <= n; t++) {
                if (t == 0) {
                    arrPars[i][t] = 0;
                } else {
                    arrPars[i][t] = scanner.nextInt();
                }
            }

            for (int j = 1; j <= n; j++) {
                if (arrPars[i][j] <= 0) continue;

                int k = arrPars[i][j];
                if (table[j] == -1) {
                    table[j] = table[i] + k;

                    path[j] = i;
                } else if (table[i] + k < table[j]) {
                    table[j] = table[i] + k;

                    path[j] = i;
                }
            }

            flag[i] = true;
        }

        if (s == f) {
            System.out.println(s);
        } else {
            int i = f;
            String fullPath = i + " ";
            do {
                if (path[i] == 0 && i != s) {
                    fullPath = "-1";
                    break;
                }
                i = path[i];
                fullPath = i + " " + fullPath;
            } while (i != s);

            System.out.println(fullPath);
        }
    }
}

