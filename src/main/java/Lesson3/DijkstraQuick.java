package Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class DijkstraQuick {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader reader = new BufferedReader(new FileReader("1.txt"));
        String str = reader.readLine();
        Scanner scanner = new Scanner(str);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Pair2>> lists = new ArrayList<>();
        for (int i = 1; i <= n+1; i++)  {
            lists.add(new ArrayList<>());
        }

        for (int i = 1; i <= k; i++) {
            StringTokenizer tokenizer= new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int l = Integer.parseInt(tokenizer.nextToken());
            lists.get(a).add(new Pair2(b, l));
            lists.get(b).add(new Pair2(a, l));
        }

        scanner = new Scanner(reader.readLine());
        int s = scanner.nextInt();
        int f = scanner.nextInt();

        BigInteger[] table = new BigInteger[n+1];
        for (int i = 0; i < n+1; i++) {
            table[i] = BigInteger.valueOf(-1);
        }
        table[s] = BigInteger.ZERO;

        TreeSet<PairSet> set = new TreeSet<>(Comparator.comparing((PairSet p)->p.getValue())
                .thenComparing(p->p.getIndex()));
        Set<Integer> visited = new HashSet<>();
        visited.add(s);
        for (Pair2 pair : lists.get(s)) {
            int v = pair.getIndex();
            int m = pair.getValue();
            set.add(new PairSet(v, BigInteger.valueOf(m)));
            table[v] = BigInteger.valueOf(m);
        }

        while (!set.isEmpty()) {
            PairSet pair = set.first();
            set.remove(pair);

            int i = pair.getIndex();
            BigInteger m = pair.getValue();
            visited.add(i);

            List<Pair2> list = lists.get(i);
            int sizeLink = list.size();
            for (int j = 0; j < sizeLink; j++) {
                int i1 = list.get(j).getIndex();
                int i2 = list.get(j).getValue();
                if (!visited.contains(i1) && (table[i1].equals(BigInteger.valueOf(-1)) || BigInteger.valueOf(i2).add(m).compareTo(table[i1]) < 0)) {
                    table[i1] = BigInteger.valueOf(i2).add(m);
                    //set.remove(list.get(j));
                    set.add(new PairSet(i1, table[i1]));
                }
            }
        }

        System.out.println(table[f]);
    }
}


class Pair2 {
    private int index;
    private int value;

    public Pair2(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair2 pair = (Pair2) o;
        return index == pair.index && value == pair.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, value);
    }
}

class PairSet {
    private int index;
    private BigInteger value;

    public PairSet(int index, BigInteger value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public BigInteger getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairSet pair = (PairSet) o;
        return index == pair.index && value == pair.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, value);
    }
}

