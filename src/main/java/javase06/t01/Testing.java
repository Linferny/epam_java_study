package javase06.t01;

import java.util.*;

public class Testing {
    public static void main(String[] args) {
        Map<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            hash.put(Integer.toString(i), i);
        }

        hash.put(null, 2);

        hash.put(null, 4);

        System.out.println(hash.get(null));

        long t = System.nanoTime();
        hash.get("0");
        System.out.println(System.nanoTime() - t);
        t = System.nanoTime();
        hash.get("500000");
        System.out.println(System.nanoTime() - t);
    }
}
