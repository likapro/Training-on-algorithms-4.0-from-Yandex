package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GroupProject {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.valueOf(tokenizer.nextToken());
            int a = Integer.valueOf(tokenizer.nextToken());
            int b = Integer.valueOf(tokenizer.nextToken());

            String rez = "NO";

            for (int j = 0, k = a; j < b-a+1; j++, k++) {
                int remains = n%k;
                int group = n/k;
                if ((b-k)*group-remains >= 0) {
                    rez = "YES";
                    break;
                }
            }

            System.out.println(rez);
        }
    }
}
