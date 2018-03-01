package javase02.t02.logic;

import javase02.t02.stationery.Stationery;
import javase02.t02.stationery.characteristics.StationeryType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StationeryCounter {
    private List<Stationery> stationeries;
    private HashMap<StationeryType, Integer> counter;

    public StationeryCounter() {
        stationeries = new ArrayList<>();
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

    public void addStationery(Stationery stationery) {
        if (stationeries.contains(stationery))
            return;
        stationeries.add(stationery);
        counter.replace(stationery.getType(), counter.get(stationery.getType()) + 1);
    }

    public void removeStationery(Stationery stationery) {
        if (stationeries.remove(stationery))
            counter.replace(stationery.getType(), counter.get(stationery.getType()) - 1);
    }
}
