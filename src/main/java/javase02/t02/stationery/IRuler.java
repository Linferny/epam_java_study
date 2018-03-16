package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.Material;

public interface IRuler extends IStationery {
    double getLength();

    Material getMaterial();

    interface Builder<T extends IRuler, V extends Builder<T, V>> extends IStationery.Builder<T, V> {
        V setLength(double length);

        V setMaterial(Material material);
    }
}
