package javase01.t02.main;

import javase01.t02.logic.Logic;

public class Main {
    public static void main(String[] args) {
        Logic l = new Logic();

        int arrayLength = 20;
        double e = 1.0 / 16;

        l.findMinIndex(arrayLength, e);
    }
}
