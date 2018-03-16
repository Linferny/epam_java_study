package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.*;
import javase02.t02.stationery.characteristics.StationeryType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Pen implements IPen {
    private double length;
    private Material material;
    private Color inkColor;

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public Color getColor() {
        return inkColor;
    }

    private Stationery _super;

    private Pen() {
    }

    @Override
    public String getName() {
        return _super.getName();
    }

    @Override
    public double getPrice() {
        return _super.getPrice();
    }

    @Override
    public StationeryType getType() {
        return _super.getType();
    }

    public static class Builder implements IPen.Builder<Pen, Builder> {

        private Pen pen;
        private IStationery.Builder superBuilder;

        private <T extends IStationery, V extends IStationery.Builder<T, V>> Builder init(IStationery.Builder<T, V> superBuilder, Pen pen) {
            this.superBuilder = superBuilder;
            this.pen = pen;
            return this;
        }

        @Override
        public Pen build() {
            try {
                pen._super = (Stationery) superBuilder.build();
                return pen;
            } finally {
                pen = null;
            }
        }

        @Override
        public Builder setMaterial(Material material) {
            pen.material = material;
            return this;
        }

        @Override
        public Builder setLength(double length) {
            pen.length = length;
            return this;
        }

        @Override
        public Builder setColor(Color inkColor) {
            pen.inkColor = inkColor;
            return this;
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
        return builder.init(Stationery.getBuilder(StationeryType.PEN), new Pen());
    }

    protected String[] getFields() {
        return new String[]{
                getType().name(), getName(), Double.toString(getPrice()), getColor().name(), getMaterial().name(), Double.toString(getLength())};
    }

    @Override
    public String toString() {
        return Arrays.stream(getFields())
                .filter(x -> x != null)
                .collect(Collectors.joining(", "));
    }
}
