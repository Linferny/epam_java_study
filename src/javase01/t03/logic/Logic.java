package javase01.t03.logic;

public class Logic {
    public void findFunctionValues(double a, double b, double h) {
        StringBuilder print = new StringBuilder(String.format("|%16s|%16s|\n", "x", "F(x)"));
        print.append("|----------------|----------------|\n");

        for (double x = a; x <= b; x += h) {
            print.append(String.format("|% 16f|% 16f|\n", x, Math.tan(2 * x) - 3));
        }

        print.append("|----------------|----------------|\n");

        System.out.println(print);
    }
}
