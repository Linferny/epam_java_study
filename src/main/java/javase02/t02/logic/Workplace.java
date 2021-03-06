package javase02.t02.logic;

import javase02.t02.stationery.IStationery;
import javase02.t02.stationery.Stationery;
import javase02.t02.stationery.characteristics.StationeryType;

import java.util.ArrayList;
import java.util.List;

public class Workplace {
    private List<IStationery> stationeries;
    private StationeryCounter counter;

    public Workplace() {
        stationeries = new ArrayList<>();
        counter = new StationeryCounter(stationeries);
    }

    public Stationery[] getStationeries(){
        return counter.getStationeries();
    }

    public void addStationery(IStationery stationery){
        counter.addStationery(stationery);
    }

    public void removeStationery(IStationery stationery){
        counter.removeStationery(stationery);
    }

    public double getAllValue(){
        return counter.getAllValue();
    }

    public int getStationeryCount(StationeryType type){
        return counter.getCount(type);
    }
}
