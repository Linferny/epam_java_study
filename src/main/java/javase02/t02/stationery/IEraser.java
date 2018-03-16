package javase02.t02.stationery;

public interface IEraser extends IStationery {
    double getWeight();

    interface Builder<T extends IEraser, V extends Builder<T, V>> extends IStationery.Builder<T, V> {
        V setWeight(double weight);
    }
}
