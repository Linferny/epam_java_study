package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.Material;
import javase02.t02.stationery.characteristics.StationeryType;

public class Ruler extends Stationery {
    private int length;
    private Material material;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Ruler(double price, int length, Material material) {
        super(price);
        super.type = StationeryType.RULER;
        this.length = length;
        this.material = material;
    }
}
