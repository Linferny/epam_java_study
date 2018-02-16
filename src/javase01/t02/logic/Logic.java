package javase01.t02.logic;

public class Logic {
    public void findMinIndex(int n, double e) {
        StringBuilder print = new StringBuilder(String.format("--------------------\nEps value: %f\n--------------------\n", e));
        int index = -1;

        for (int i = 0; i < n; i++) {
            double val = 1 / Math.pow(1 + i, 2);

            if (index == -1 && val < e)
                index = i;
            print.append(String.format("%-6d: % -20f\n", i, val));
        }

        print.append("--------------------\nIndex: ");
        print.append(index == -1 ? "Value not found" : index);

        System.out.println(print);
    }
}
