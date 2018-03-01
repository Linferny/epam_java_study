package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.StationeryType;

public class Eraser extends Stationery {
    private int weight;

    public Eraser(double price, int weight) {
        super(price);
        super.type = StationeryType.ERASER;
        this.weight = weight;
    }
}
