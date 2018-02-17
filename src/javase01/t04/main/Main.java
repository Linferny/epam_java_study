package javase01.t04.main;

import javase01.t04.logic.Logic;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Logic l = new Logic();
        Random random = new Random();
        int arrSize = 20;
        double[] arr = new double[arrSize];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextDouble() - random.nextDouble();
        }

        System.out.println(String.format("Max value: %f", l.findMaxSum(arr)));
    }
}
