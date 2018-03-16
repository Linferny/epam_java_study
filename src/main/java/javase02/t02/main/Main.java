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

        pen1 = Pen.getBuilder().setColor(Color.BLUE).setLength(7).setMaterial(Material.METAL).setName("Parker 1").setPrice(46.75).build();
        pen2 = Pen.getBuilder().setColor(Color.BLACK).setLength(11).setMaterial(Material.PLASTIC).setName("Parker 0").setPrice(15).build();
        pencil1 = Pencil.getBuilder().setPrice(10).setName("Constructor 1").setMaterial(Material.WOOD).setColor(Color.GREY).setHardness(Hardness.HB).setLength(10).build();
        pencil2 = Pencil.getBuilder().setPrice(20).setName("Constructor 2").setMaterial(Material.WOOD).setColor(Color.GREY).setHardness(Hardness.B2).setLength(10).build();
        pencil3 = Pencil.getBuilder().setPrice(30).setName("Constructor 3").setMaterial(Material.WOOD).setColor(Color.GREY).setHardness(Hardness.H).setLength(10).build();
        ruler1 = Ruler.getBuilder().setName("RULA").setPrice(46.75).setLength(40).setMaterial(Material.METAL).build();


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

        System.out.println("Delete pen №1 three times");
        adam.removeStationery(pen1);
        adam.removeStationery(pen1);
        adam.removeStationery(pen1);

        System.out.println();
        System.out.println(String.format("Pens count: %d", adam.getStationeryCount(StationeryType.PEN)));
        System.out.println(String.format("All value: %f", adam.getAllValue()));
    }
}
