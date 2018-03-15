package javase02.t02.main;

import javafx.css.Rule;
import javase02.t02.logic.Worker;
import javase02.t02.logic.Workplace;
import javase02.t02.stationery.characteristics.*;
import javase02.t02.logic.StationeryCounter;
import javase02.t02.stationery.Pen;
import javase02.t02.stationery.Pencil;
import javase02.t02.stationery.Ruler;

public class Main {
    public static void main(String[] args) {
        Worker adam = new Worker("Adam", "Thomas", "Jerry");
        Workplace workplace = new Workplace();
        adam.setWorkplace(workplace);

        Pen pen1;
        Pen pen2;
        Pencil pencil1;
        Pencil pencil2;
        Pencil pencil3;
        Ruler ruler1;

        pen1 = new Pen(46.75, "Parker Simple", 7, Material.METAL, Color.BLACK);
        pen2 = new Pen(15, "Parker Wood", 11, Material.PLASTIC, Color.BLACK);
        pencil1 = new Pencil(10, "Constructor 1", Material.WOOD, Color.GREY, Hardness.HB, 10);
        pencil2 = new Pencil(20, "Constructor 2", Material.WOOD, Color.GREY, Hardness.B2, 10);
        pencil3 = new Pencil(30, "Constructor 3", Material.WOOD, Color.GREY, Hardness.H, 10);
        ruler1 = new Ruler(45, "Ruler", 30, Material.WOOD);


        adam.addStationery(pen1);
        adam.addStationery(pen2);
        adam.addStationery(pencil1);
        adam.addStationery(pencil2);
        adam.addStationery(pencil3);
        adam.addStationery(ruler1);
        adam.addStationery(ruler1);
        adam.addStationery(ruler1);
        adam.addStationery(ruler1);

        System.out.println(String.format("Pens count: %d", adam.getStationeryCount(StationeryType.PEN)));
        System.out.println(String.format("Pencils count: %d", adam.getStationeryCount(StationeryType.PENCIL)));
        System.out.println(String.format("Rulers count: %d", adam.getStationeryCount(StationeryType.RULER)));
        System.out.println(String.format("All value: %f", adam.getAllValue()));

        adam.removeStationery(pen1);
        adam.removeStationery(pen1);
        adam.removeStationery(pen1);

        System.out.println();
        System.out.println(String.format("Pens count: %d", adam.getStationeryCount(StationeryType.PEN)));
        System.out.println(String.format("All value: %f", adam.getAllValue()));
    }
}
