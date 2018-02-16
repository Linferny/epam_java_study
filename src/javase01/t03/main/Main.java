package javase01.t03.main;

import javase01.t03.logic.Logic;

public class Main {
    public static void main(String[] args) {
        Logic l = new Logic();

        double a = 1.0;
        double b = 5.0;
        double h = 0.3;

        l.findFunctionValues(a, b, h);
    }
}
