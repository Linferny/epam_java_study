package javase01.t01.main;

import com.oracle.tools.packager.Log;
import javase01.t01.logic.Logic;

import java.util.Formatter;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //hw_1-1
        Logic logic = new Logic();
        System.out.println(logic.method());

        //hw_1-2
        hw_1_2(10, 0.001);

        //hw_1-3
        hw_1_3(2, 5, 0.73);

        //hw_1-4
        hw_1_4(10);
    }

    public static void hw_1_2(int n, double e) {
        if (n < 0) {
            System.out.println("ERR: n must be greater than 0!");
        }
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = 1 / Math.pow(i + 1, 2);
        }
        int index = Logic.getMinimalWithCondition(array, e);
        StringBuilder str = new StringBuilder();
        for (double d : array) {
            str.append(d);
            str.append(' ');
        }
        str.append('\n');
        str.append("Index: ");
        str.append(index == -1 ? "No correct value found" : index);
        System.out.println(str);
    }

    public static void hw_1_3(double a, double b, double h) {
        StringBuilder str = new StringBuilder();
        str.append(String.format("|%20s|%20s|\n", "x", "F(x)"));
        for (double x = a; x < b; x += h) {
            double res = Logic.getFunction_hw_1_3(x);
            str.append(String.format("|%20f|%20f|\n", x, res));
        }
        System.out.println(str);
    }

    public static void hw_1_4(int n) {
        Random random = new Random();
        if (n % 2 == 1)
            --n;
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (2 * random.nextDouble() - random.nextDouble()) * Math.pow(10, random.nextInt(4));
        }
        double max = Logic.getMaxValue_hw_1_4(arr);
        for (double d : arr)
            System.out.print(String.format("%f ", d));
        if (max != Double.NEGATIVE_INFINITY)
            System.out.println(String.format("\nMax value: %f", max));
        else
            System.out.println("\nArray to small!");
    }
}
