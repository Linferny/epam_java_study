package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.StationeryType;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Eraser implements IEraser {
    private double weight;

    @Override
    public double getWeight() {
        return weight;
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

    public static class Builder implements IEraser.Builder<Eraser, Builder> {
        private Eraser eraser;
        private IStationery.Builder superBuilder;

        public <T extends IStationery, V extends IStationery.Builder<T, V>> Builder init(IStationery.Builder<T, V> superBuilder, Eraser eraser) {
            this.superBuilder = superBuilder;
            this.eraser = eraser;
            return this;
        }

        @Override
        public Builder setWeight(double weight) {
            eraser.weight = weight;
            return this;
        }

        @Override
        public Eraser build() {
            try {
                eraser._super = (Stationery)superBuilder.build();
                return eraser;
            } finally {
                eraser = null;
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
        return builder.init(Stationery.getBuilder(StationeryType.ERASER), new Eraser());
    }

    protected String[] getFields() {
        return new String[]{
                getType().name(), getName(), Double.toString(getPrice()), Double.toString(getWeight())};
    }

    @Override
    public String toString() {
        return Arrays.stream(getFields())
                .filter(x -> x != null)
                .collect(Collectors.joining(", "));
    }
}
