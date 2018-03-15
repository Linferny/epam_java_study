package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.*;
import javase02.t02.stationery.characteristics.StationeryType;

public class Pen extends Stationery {
    private int length;
    private Material material;
    private Color inkColor;

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

    public Color getInkColor() {
        return inkColor;
    }

    public void setInkColor(Color inkColor) {
        this.inkColor = inkColor;
    }

    public Pen(double price, String name, int length, Material material, Color inkColor) {
        super(price, name, StationeryType.PEN);
        this.length = length;
        this.material = material;
        this.inkColor = inkColor;
    }
}
