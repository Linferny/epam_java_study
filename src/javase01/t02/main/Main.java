package javase01.t02.main;

import javase01.t02.logic.Logic;

public class Main {
    public static void main(String[] args) {
        Logic l = new Logic();

        int arrayLength = 20;
        double e = 1.0 / 16;
        double[] arr = new double[arrayLength];
        StringBuilder print = new StringBuilder(String.format("--------------------\nEps value: %f\n--------------------\n", e));
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 / Math.pow(1 + i, 2);
            print.append(String.format("%-6d: % -20f\n", i, arr[i]));
        }

        int index = l.findMinIndex(arr, e);

        print.append("--------------------\nIndex: ");
        print.append(index == -1 ? "Value not found" : index);

        System.out.println(print);
    }
}
