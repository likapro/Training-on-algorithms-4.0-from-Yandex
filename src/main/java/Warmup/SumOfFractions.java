package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfFractions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String n = reader.readLine();
        String[] arrStr = n.split(" ");
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int m1= arr[0] * arr[3];
        int n1= arr[2] * arr[1];
        int com= arr[1] * arr[3];

        int m1n1 = m1 + n1;

        int gsdInt = gcd(m1n1, com);

        System.out.println(m1n1/gsdInt + " " + com/gsdInt);
    }

    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
