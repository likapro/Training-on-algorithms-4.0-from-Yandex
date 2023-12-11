package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EqualitySubstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int q = Integer.parseInt(reader.readLine());

        int[] h = new int[str.length()+1];
        int[] strCode = new int[str.length()+1];
        h[0] = 0;
        for (int j = 1; j < h.length; j++) {
            strCode[j] = (int)str.charAt(j-1);
            h[j] = h[j-1] * 10 + strCode[j];
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int l = Integer.valueOf(tokenizer.nextToken());
            int a = Integer.valueOf(tokenizer.nextToken());
            int b = Integer.valueOf(tokenizer.nextToken());

            int hashAL = h[a+l] - h[a] * (int)Math.pow(10,  l);
            int hashBL = h[b+l] - h[b] * (int)Math.pow(10,  l);

            if (hashAL == hashBL) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
