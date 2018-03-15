package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.StationeryType;

public class Eraser extends Stationery {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Eraser(double price, String name, int weight) {
        super(price, name, StationeryType.ERASER);
        this.weight = weight;
    }
}
