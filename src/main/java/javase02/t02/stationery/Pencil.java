package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.Color;
import javase02.t02.stationery.characteristics.Hardness;
import javase02.t02.stationery.characteristics.Material;
import javase02.t02.stationery.characteristics.StationeryType;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Pencil implements IPencil {
    private Material material;
    private Color graphiteColor;
    private Hardness hardness;
    private double length;

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public Color getColor() {
        return graphiteColor;
    }

    @Override
    public Hardness getHardness() {
        return hardness;
    }

    @Override
    public double getLength() {
        return length;
    }

    private Stationery _super;

    @Override
    public StationeryType getType() {
        return _super.getType();
    }

    @Override
    public double getPrice() {
        return _super.getPrice();
    }

    @Override
    public String getName() {
        return _super.getName();
    }

    public static class Builder implements IPencil.Builder<Pencil, Builder> {

        private Pencil pencil;
        private IStationery.Builder superBuilder;

        private <T extends IStationery, V extends IStationery.Builder<T, V>> Builder init(IStationery.Builder<T, V> superBuilder, Pencil pencil) {
            this.superBuilder = superBuilder;
            this.pencil = pencil;
            return this;
        }

        @Override
        public Builder setMaterial(Material material) {
            pencil.material = material;
            return this;
        }

        @Override
        public Builder setColor(Color color) {
            pencil.graphiteColor = color;
            return this;
        }

        @Override
        public Builder setHardness(Hardness hardness) {
            pencil.hardness = hardness;
            return this;
        }

        @Override
        public Builder setLength(double length) {
            pencil.length = length;
            return this;
        }

        @Override
        public Pencil build() {
            try {
                pencil._super = (Stationery) superBuilder.build();
                return pencil;
            } finally {
                pencil = null;
            }
        }

        @Override
        public Builder setPrice(double price) {
            superBuilder.setPrice(price);
            return this;
        }

        @Override
        public Builder setName(String name) {
            superBuilder.setName(name);
            return this;
        }
    }

    private static Builder builder;

    public static Builder getBuilder() {
        if (builder == null)
            builder = new Builder();
        return builder.init(Stationery.getBuilder(StationeryType.PENCIL), new Pencil());
    }

    protected String[] getFields() {
        return new String[]{
                getType().name(), getName(), Double.toString(getPrice()), getHardness().name(), getColor().name(), getMaterial().name(), Double.toString(getLength())};
    }

    @Override
    public String toString() {
        return Arrays.stream(getFields())
                .filter(x -> x != null)
                .collect(Collectors.joining(", "));
    }
}
