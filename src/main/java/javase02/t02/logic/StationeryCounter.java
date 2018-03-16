package javase02.t02.logic;

import javase02.t02.stationery.IStationery;
import javase02.t02.stationery.Stationery;
import javase02.t02.stationery.characteristics.StationeryType;

import java.util.HashMap;
import java.util.List;

public class StationeryCounter {
    private List<IStationery> stationeries;
    private HashMap<StationeryType, Integer> counter;

    public StationeryCounter(List<IStationery> stationeries) {
        this.stationeries = stationeries;
        counter = new HashMap<>();
        for (StationeryType s:
                StationeryType.values())
            counter.put(s, 0);
    }

    public Stationery[] getStationeries(){
        Stationery[] result = new Stationery[stationeries.size()];
        System.arraycopy(stationeries, 0, result, 0, result.length);
        return result;
    }

    public int getCount(StationeryType type){
        return counter.get(type);
    }

    public void addStationery(IStationery stationery) {
        if (stationeries.contains(stationery))
            return;
        stationeries.add(stationery);
        counter.replace(stationery.getType(), counter.get(stationery.getType()) + 1);
    }

    public void removeStationery(IStationery stationery) {
        if (stationeries.remove(stationery))
            counter.replace(stationery.getType(), counter.get(stationery.getType()) - 1);
    }

    public double getAllValue(){
        double val = 0;
        for (IStationery s:
             stationeries) {
            val += s.getPrice();
        }
        return val;
    }
}
