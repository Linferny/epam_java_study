package javase02.t02.main;

import javafx.css.Rule;
import javase02.t02.stationery.characteristics.*;
import javase02.t02.logic.StationeryCounter;
import javase02.t02.stationery.Pen;
import javase02.t02.stationery.Pencil;
import javase02.t02.stationery.Ruler;

public class Main {
    public static void main(String[] args) {
        StationeryCounter counter = new StationeryCounter();

        Pen pen1;
        Pen pen2;
        Pencil pencil1;
        Pencil pencil2;
        Pencil pencil3;
        Ruler ruler1;

        pen1 = new Pen(46.75, 7, Material.METAL, Color.BLACK);
        pen2 = new Pen(15, 11, Material.PLASTIC, Color.BLACK);
        pencil1 = new Pencil(10, Material.WOOD, Color.GREY, Hardness.HB, 10);
        pencil2 = new Pencil(20, Material.WOOD, Color.GREY, Hardness.B2, 10);
        pencil3 = new Pencil(30, Material.WOOD, Color.GREY, Hardness.H, 10);
        ruler1 = new Ruler(45, 30, Material.WOOD);

        counter.addStationery(pen1);
        counter.addStationery(pen2);
        counter.addStationery(pencil1);
        counter.addStationery(pencil2);
        counter.addStationery(pencil3);
        counter.addStationery(ruler1);
        counter.addStationery(ruler1);
        counter.addStationery(ruler1);
        counter.addStationery(ruler1);

        System.out.println(String.format("Pens count: %d", counter.getCount(StationeryType.PEN)));
        System.out.println(String.format("Pencils count: %d", counter.getCount(StationeryType.PENCIL)));
        System.out.println(String.format("Rulers count: %d", counter.getCount(StationeryType.RULER)));

        counter.removeStationery(pen1);
        counter.removeStationery(pen1);
        counter.removeStationery(pen1);

        System.out.println();
        System.out.println(String.format("Pens count: %d", counter.getCount(StationeryType.PEN)));
    }
}
