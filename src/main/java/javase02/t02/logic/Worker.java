package javase02.t02.logic;

import javase02.t02.stationery.Stationery;
import javase02.t02.stationery.characteristics.StationeryType;

public class Worker {
    private String name;
    private String surname;
    private String patronymic;
    private Workplace workplace;

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    public Worker(String name, String surname, String patronymic, Workplace workplace) {

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.workplace = workplace;
    }

    public Worker(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public void addStationery(Stationery stationery){
        workplace.addStationery(stationery);
    }

    public void removeStationery(Stationery stationery){
        workplace.removeStationery(stationery);
    }

    public Stationery[] getStationeries(){
        return workplace.getStationeries();
    }

    public double getAllValue(){
        return workplace.getAllValue();
    }

    public int getStationeryCount(StationeryType type){
        return workplace.getStationeryCount(type);
    }
}
