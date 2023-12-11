package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class NotMinimum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[2];
        String n = reader.readLine();
        String[] arrStr = n.split(" ");
        for (int i = 0; i < 2; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int[] arr2 = new int[arr[0]];
        String m = reader.readLine();
        String[] arrStr2 = m.split(" ");
        for (int i = 0; i < arr[0]; i++) {
            arr2[i] = Integer.parseInt(arrStr2[i]);
        }

        for (int i = 0; i < arr[1]; i++) {
            int[] lr = new int[2];
            String b = reader.readLine();
            String[] lrStr = b.split(" ");
            for (int j = 0; j < 2; j++) {
                lr[j] = Integer.parseInt(lrStr[j]);
            }

            Set<Integer> set = new TreeSet<>();
            for(int j = lr[0]; j <= lr[1]; j++) {
                set.add(arr2[j]);
            }

            if(set.size() == 1) {
                System.out.println("NOT FOUND");
            } else {
                int max = set.stream().max(Comparator.comparingInt(o -> o)).get();
                System.out.println(max);
            }
        }
    }
}
