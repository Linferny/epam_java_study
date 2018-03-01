package javase02.t01.main;

import javase02.t01.stationery.Pen;
import javase02.t01.stationery.characteristics.*;

public class Main {
    public static void main(String[] args) {
        Pen pen1;
        Pen pen2;
        Pen pen3;
        pen1 = new Pen(10, 1.7, InkColor.BLUE, PenMaterial.PLASTIC, PenType.AUTOMATIC, 47.50);
        pen2 = new Pen(10, 1.7, InkColor.BLUE, PenMaterial.PLASTIC, PenType.AUTOMATIC, 46.75 + 0.74 + 0.01);
        pen3 = new Pen(10, 1.5, InkColor.BLUE, PenMaterial.PLASTIC, PenType.AUTOMATIC, 47.50);

        System.out.println(String.format("pen1 equals pen2: %s", pen1.equals(pen2)));
        System.out.println(String.format("pen1 equals pen3: %s", pen1.equals(pen3)));
        System.out.println(String.format("pen1 hash: %d", pen1.hashCode()));
        System.out.println(String.format("pen2 hash: %d", pen2.hashCode()));
        System.out.println(String.format("pen3 hash: %d", pen3.hashCode()));
        System.out.println(String.format("pen1 to string: %s", pen1.toString()));
    }
}
