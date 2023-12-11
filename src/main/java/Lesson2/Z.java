package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Z {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        int n = str.length();
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; i++) {

            if (i <= r) {
                int j = i - l;
                if (i + z[j] <= r) {
                    z[i] = z[j];
                } else {
                    int count = countZ(i, str);
                    z[i] = count;
                    l = i;
                    r = i + count -1;
                }
            } else {
                int count = countZ(i, str);
                z[i] = count;
                l = i;
                r = i + count -1;
            }
        }

        for (int i = 0; i < z.length; i++) System.out.print(z[i] + " ");
    }

    private static int countZ (int i, String str) {
        int count = 0;
        for (int len = 0; len < str.length()-i; len++) {
            if ( str.charAt(len) == str.charAt(i+len) ) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}

