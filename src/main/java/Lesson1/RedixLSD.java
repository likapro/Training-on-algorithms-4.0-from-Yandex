package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RedixLSD {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String countStr = reader.readLine();
        int count = Integer.parseInt(countStr);

        if(count == 0) {
            System.out.println("");
            return;
        }

        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = reader.readLine();
        }

        redixLSD(arr);
    }

    public static void redixLSD(String[] arr) {
        System.out.println("Initial array:");
        for(int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) System.out.println(arr[i]);
            else System.out.print(arr[i] + ", ");
        }
        System.out.println("**********");

        int max = arr[0].length();
        for(int i = 0; i < max; i++) {
            int index = max-i-1;
            ArrayList<String>[] backets = new ArrayList[10];

            for (int j = 0; j < arr.length; j++) {
                int el = Integer.parseInt(String.valueOf(arr[j].charAt(index)));
                ArrayList<String> backet = backets[el];
                if(backet == null) backet = new ArrayList<>();
                backet.add(arr[j]);
                backets[el] = backet;
            }

            System.out.println("Phase " + (i+1));
            for (int j = 0, indArr = 0; j < 10; j++) {
                String s = "";
                ArrayList<String> backet = backets[j];
                if (backet == null) s = "empty";
                else {
                    for(int l = 0; l < backet.size(); l++) {
                        arr[indArr++] = backet.get(l);
                        if(l == backet.size()-1) s += backet.get(l);
                        else s += backet.get(l) + ", ";
                    }
                }
                System.out.println("Bucket " + j + ": " + s);
            }
            System.out.println("**********");
        }

        System.out.println("Sorted array:");
        for(int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) System.out.println(arr[i]);
            else System.out.print(arr[i] + ", ");
        }
    }
}
