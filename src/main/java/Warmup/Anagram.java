package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word1 = reader.readLine();
        String word2 = reader.readLine();

        Map<Character, Integer> word1Map = new HashMap<>();
        for(char c : word1.toCharArray()) {
            word1Map.put(c, word1Map.getOrDefault(c, 0) +1);
        }

        Map<Character, Integer> word2Map = new HashMap<>();
        for(char c : word2.toCharArray()) {
            word2Map.put(c, word2Map.getOrDefault(c, 0) +1);
        }

        String rez = "YES";
        if (word1Map.hashCode() != word2Map.hashCode()) {
            rez = "NO";
        } else {
            for (char key : word1Map.keySet()) {
                if (!word1Map.get(key).equals(word2Map.get(key) )) {
                    rez = "NO";
                    break;
                }
            }
        }

        System.out.println(rez);

    }

}
