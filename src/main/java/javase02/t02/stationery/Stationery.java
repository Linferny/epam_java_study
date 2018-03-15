package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.StationeryType;


public abstract class Stationery{
    protected StationeryType type;
    protected double price;
    protected String name;

    public Stationery(double price, String name, StationeryType type) {
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
