package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.StationeryType;

public class Stationery {
    protected StationeryType type;
    protected double price;

    public Stationery(double price) {
        this.price = price;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StationeryType getType() {
        return type;
    }
}
