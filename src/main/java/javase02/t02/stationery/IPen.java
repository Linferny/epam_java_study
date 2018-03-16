package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.Color;
import javase02.t02.stationery.characteristics.Material;

public interface IPen extends IStationery {
    double getLength();

    Material getMaterial();

    Color getColor();

    interface Builder<T extends IPen, V extends Builder<T, V>> extends IStationery.Builder<T, V> {
        V setMaterial(Material material);

        V setLength(double length);

        V setColor(Color inkColor);
    }
}
