package Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Scanner scanner = new Scanner(str);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Pair>> lists = new ArrayList<>();
        for (int i = 1; i <= n+1; i++)  {
            lists.add(new LinkedList<>());
        }

        for (int i = 1; i <= k; i++) {
            scanner = new Scanner(reader.readLine());
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int l = scanner.nextInt();
            lists.get(a).add(new Pair(b, l));
            lists.get(b).add(new Pair(a, l));
        }

        scanner = new Scanner(reader.readLine());
        int s = scanner.nextInt();
        int f = scanner.nextInt();

        int[] table = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            table[i] = -1;
        }
        table[s] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getI2));
        Set<Integer> visited = new HashSet<>();
        visited.add(s);
        for (Pair pair : lists.get(s)) {
            int v = pair.getI1();
            int m = pair.getI2();
            queue.add(new Pair(v, m));
            table[v] = m;
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            queue.remove(pair);

            int i = pair.getI1();
            int m = pair.getI2();
            visited.add(i);

            for (Pair pairI : lists.get(i)) {
                int i1 = pairI.getI1();
                int i2 = pairI.getI2();
                if (!visited.contains(i1) && (table[i1] == -1 || i2 + m < table[i1])) {
                    table[i1] = i2 + m;
                    queue.remove(pairI);
                    queue.add(new Pair(i1, i2 + m));
                }
            }
        }

        System.out.println(table[f]);
    }
}


class Pair {
    private int i1;
    private int i2;

    public Pair(int len, int vert) {
        this.i1 = len;
        this.i2 = vert;
    }

    public int getI1() {
        return i1;
    }

    public int getI2() {
        return i2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return i1 == pair.i1 && i2 == pair.i2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i1, i2);
    }
}

