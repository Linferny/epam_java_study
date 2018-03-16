package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.StationeryType;

public interface IStationery {
    StationeryType getType();
    double getPrice();
    String getName();

    interface Builder<T extends IStationery, V extends IStationery.Builder<T,V>>{
        T build();

        V setPrice(double price);
        V setName(String name);
    }
}
