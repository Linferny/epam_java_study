package javase02.t02.stationery;

import javase02.t02.stationery.characteristics.Material;
import javase02.t02.stationery.characteristics.StationeryType;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Ruler implements IRuler {
    private double length;
    private Material material;

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public Material getMaterial() {
        return material;
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

    public static class Builder implements IRuler.Builder<Ruler, Builder>{

        private Ruler ruler;
        private IStationery.Builder superBuilder;

        private <T extends IStationery, V extends IStationery.Builder<T,V>> Builder init(IStationery.Builder<T,V> superBuilder, Ruler ruler){
            this.superBuilder = superBuilder;
            this.ruler = ruler;
            return this;
        }

        @Override
        public Builder setLength(double length) {
            ruler.length = length;
            return this;
        }

        @Override
        public Builder setMaterial(Material material) {
            ruler.material = material;
            return this;
        }

        @Override
        public Ruler build() {
            try {
                ruler._super = (Stationery)superBuilder.build();
                return ruler;
            }finally {
                ruler = null;
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
        return builder.init(Stationery.getBuilder(StationeryType.ERASER), new Ruler());
    }

    protected String[] getFields() {
        return new String[]{
                getType().name(), getName(), Double.toString(getPrice()), getMaterial().name(), Double.toString(getLength())};
    }

    @Override
    public String toString() {
        return Arrays.stream(getFields())
                .filter(x -> x != null)
                .collect(Collectors.joining(", "));
    }
}
