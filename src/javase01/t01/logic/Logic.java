package javase01.t01.logic;

public class Logic {
    public String method() {
        return "I am string in Logic.";
    }

    public static int getMinimalWithCondition(double[] array, double e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < e) {
                return i;
            }
        }
        return -1;
    }

    public static double getFunction_hw_1_3(double x) {
        return Math.tan(2 * x) - 3;
    }

    public static double getMaxValue_hw_1_4(double[] arr) {
        if (arr.length < 2)
            return Double.NEGATIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < arr.length / 2; i++) {
            double sum = arr[i] + arr[arr.length - 1 - i];
            if (sum > max)
                max = sum;
        }
        return max;
    }
}
