package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResultContest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new FileReader("1.txt"));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        if (a > Math.ceil((double) b/n)) System.out.println("Yes");
        else System.out.println("No");
    }
}
