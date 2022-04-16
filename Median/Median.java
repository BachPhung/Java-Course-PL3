package Median;

import java.util.ArrayList;
import java.util.Collections;

public class Median {
    public static void main(String[] args) {
        int size = args.length;
        ArrayList<Double> list = new ArrayList<>();
        for (String arg : args) {
            list.add(Double.parseDouble(arg));
        }

        Collections.sort(list, (a, b) -> a < b ? -1 : (a > b ? 1 : 0));
        if (list.size() % 2 != 0) {
            System.out.println("Median: " + list.get(size/ 2));
        } else {
            System.out.printf("Median: %f%n", (list.get((size-1) / 2) + list.get(size / 2))/2);
        }
    }
}
