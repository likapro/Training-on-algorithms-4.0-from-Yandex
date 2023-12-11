package Lesson3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Bus {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader reader = new BufferedReader(new FileReader("1.txt"));
        Scanner scanner = new Scanner(reader.readLine());
        int n = scanner.nextInt(); // число вершин (деревень)
        scanner = new Scanner(reader.readLine());
        int s = scanner.nextInt();
        int f = scanner.nextInt();
        scanner = new Scanner(reader.readLine());
        int r = scanner.nextInt(); // количество ребер (маршрутов)

        List<List<Track>> lists = new ArrayList<>();
        for (int i = 1; i <= n+1; i++)  {
            lists.add(new ArrayList<>());
        }

        for (int i = 1; i <= r; i++) {
            StringTokenizer tokenizer= new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int timeA = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int timeB = Integer.parseInt(tokenizer.nextToken());
            lists.get(a).add(new Track(timeA, b, timeB));
        }

        BigInteger[] table = new BigInteger[n+1];
        for (int i = 0; i < n+1; i++) {
            table[i] = BigInteger.valueOf(-1);
        }
        table[s] = BigInteger.ZERO;

        TreeSet<Pair3Set> set = new TreeSet<>(Comparator.comparing((Pair3Set p)->p.getValue()).thenComparing(p->p.getIndex()));
        set.add(new Pair3Set(s, table[s]));

        Set<Integer> visited = new HashSet<>();

        while (!set.isEmpty()) {
            Pair3Set pair = set.first();
            set.remove(pair);

            int i = pair.getIndex();
            BigInteger m = pair.getValue();
            visited.add(i);

            List<Track> list = lists.get(i);
            int sizeLink = list.size();
            for (int j = 0; j < sizeLink; j++) {

                int timeStart = list.get(j).getTimeStart();
                int pointFinish = list.get(j).getPointFinish();
                int timeFinish = list.get(j).getTimeFinish();

                if (BigInteger.valueOf(timeStart).compareTo(m) >= 0 && !visited.contains(pointFinish) && (table[pointFinish].equals(BigInteger.valueOf(-1)) || BigInteger.valueOf(timeFinish).compareTo(table[pointFinish]) < 0)) {
                    table[pointFinish] = BigInteger.valueOf(timeFinish);
                    set.add(new Pair3Set(pointFinish, table[pointFinish]));
                }
            }
        }

        System.out.println(table[f]);
    }
}


class Track {
    private int timeStart;
    private int pointFinish;
    private int timeFinish;

    public Track(int timeStart, int pointFinish, int timeFinish) {
        this.timeStart = timeStart;
        this.pointFinish = pointFinish;
        this.timeFinish = timeFinish;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public int getPointFinish() {
        return pointFinish;
    }

    public int getTimeFinish() {
        return timeFinish;
    }
}

class Pair3 {
    private int index;
    private int value;

    public Pair3(int index, int value) {
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
        Pair3 pair = (Pair3) o;
        return index == pair.index && value == pair.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, value);
    }
}

class Pair3Set {
    private int index;
    private BigInteger value;

    public Pair3Set(int index, BigInteger value) {
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
        Pair3Set pair = (Pair3Set) o;
        return index == pair.index && value == pair.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, value);
    }
}