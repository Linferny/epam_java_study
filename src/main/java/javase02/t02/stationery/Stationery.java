package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.StationeryType;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Stationery implements IStationery {
    protected StationeryType type;
    protected double price;
    protected String name;

    private Stationery(StationeryType type) {
        this.type = type;
    }

    public static class Builder implements IStationery.Builder<Stationery, Builder> {
        private Stationery stationery;

        private Builder() {

        }

        private Builder init(Stationery stationery) {
            this.stationery = stationery;
            return this;
        }

        @Override
        public Stationery build() {
            try {
                return stationery;
            } finally {
                stationery = null;
            }
        }

        @Override
        public Builder setPrice(double price) {
            stationery.price = price;
            return this;
        }

        @Override
        public Builder setName(String name) {
            stationery.name = name;
            return this;
        }
    }

    private static Builder builder;

    public static Builder getBuilder(StationeryType type) {
        if (builder == null)
            builder = new Builder();
        return builder.init(new Stationery(type));
    }

    @Override
    public StationeryType getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    protected String[] getFields() {
        return new String[]{
                getType().name(), getName(), Double.toString(getPrice())};
    }

    @Override
    public String toString() {
        return Arrays.stream(getFields())
                .filter(x -> x != null)
                .collect(Collectors.joining(", "));
    }
}
