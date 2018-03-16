package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.Color;
import javase02.t02.stationery.characteristics.Hardness;
import javase02.t02.stationery.characteristics.Material;

public interface IPencil extends IStationery {
    Material getMaterial();

    Color getColor();

    Hardness getHardness();

    double getLength();

    interface Builder<T extends IPencil, V extends Builder<T, V>> extends IStationery.Builder<T, V> {
        V setMaterial(Material material);

        V setColor(Color color);

        V setHardness(Hardness hardness);

        V setLength(double length);
    }
}
