package javase01.t02.logic;

public class Logic {
    public int findMinIndex(double[] arr, double e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < e)
                return i;
        }
        return -1;
    }
}
