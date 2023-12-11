package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rabbit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.valueOf(tokenizer.nextToken());
        int m = Integer.valueOf(tokenizer.nextToken());

        int[][] arr = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.valueOf(tokenizer.nextToken());

                if (j == 0 || i == 0) continue;

                if (arr[i][j] > 0 && arr[i-1][j-1] > 0 && arr[i-1][j] > 0 && arr[i][j-1] > 0) {
                    int min = Math.min(Math.min(arr[i-1][j],arr[i][j-1]), arr[i-1][j-1]);
                    arr[i][j] = min+1;
                    max = Math.max(max, arr[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}
