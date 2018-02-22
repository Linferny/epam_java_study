package javase01.t04.logic;

public class Logic {
    public double findMaxSum(double[] arr) {
        double max = Double.NEGATIVE_INFINITY;
        double tmp;

        if (arr.length >= 2)
            for (int i = 0; i < arr.length / 2; i++) {
                tmp = arr[i] + arr[arr.length - 1 - i];
                if (tmp > max)
                    max = tmp;
            }

        return max;
    }
}
