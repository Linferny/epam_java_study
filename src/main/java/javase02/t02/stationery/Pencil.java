package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.Color;
import javase02.t02.stationery.characteristics.Hardness;
import javase02.t02.stationery.characteristics.Material;
import javase02.t02.stationery.characteristics.StationeryType;

public class Pencil extends Stationery {
    private Material material;
    private Color graphiteColor;
    private Hardness hardness;
    private int length;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Color getGraphiteColor() {
        return graphiteColor;
    }

    public void setGraphiteColor(Color graphiteColor) {
        this.graphiteColor = graphiteColor;
    }

    public Hardness getHardness() {
        return hardness;
    }

    public void setHardness(Hardness hardness) {
        this.hardness = hardness;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Pencil(double price, String name, Material material, Color graphiteColor, Hardness hardness, int length) {
        super(price, name);
        this.material = material;
        this.graphiteColor = graphiteColor;
        this.hardness = hardness;
        this.length = length;
    }
}
